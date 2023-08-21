/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@SpringBootApplication
public class KafkaBatchSampleApplication {

	Log log = LogFactory.getLog(getClass());

	public static void main(String[] args) {
		SpringApplication.run(KafkaBatchSampleApplication.class, args);
	}

	/**
	 * Gửi message vào topic: batch-in-topic, cũng tức là đưa vào binder: bindingKafka-in-{index}
	 * @param template
	 * @return
	 */
	@Bean
	public ApplicationRunner runner(KafkaTemplate<byte[], byte[]> template) {
		// Gửi vào `batch-in-topic` 7 String messages
		return args -> IntStream.range(0, 7).forEach(i -> template.send("batch-in-topic",
			("\"Message testing from SpringBoot, send to `batch-in-topic` - " + i + "\"").getBytes()));
	}


	/**
	 * Lắng nghe topic `batch-out-topic`, tương đương với binding name: `targetBindingKafka-out-0` trong auto configuration
	 */
	@KafkaListener(id = "id-Kafka01", topics = "batch-out-topic")
	public void listen(String message) {
		log.info("Received message: " + message);
	}


}

@Component
class NoTransactions {

	/**
	 * StreamBridge này sẽ hứng data chung khi chưa có định nghĩa của bindingKafka-out-{index}
	 */
	@Autowired
	StreamBridge bridge;

	/**
	 * Liên kết với config spring.cloud.stream.bindings.bindingKafka-in-0
	 * ( tên bean này là consumerKafka thì naming convention sẽ là bindingKafka-in-{index} )
	 *
	 * Khi nhận được message từ consumerKafka-in-0, ta sẽ gửi message đến channel: targetBindingKafka-out-0 để xử lý tiếp
	 *
	 * @return
	 */
	@Bean
	Consumer<List<String>> bindingKafka() {
		return list -> list.forEach(
				str -> bridge.send("targetBindingKafka-out-0", str.toUpperCase())
		);
	}

}

