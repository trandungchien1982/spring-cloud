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
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@RestController
public class ConsumerComp {

	Log log = LogFactory.getLog(getClass());

	private static AtomicInteger count = new AtomicInteger();

	@GetMapping("/consumer")
	public String consumerRequest() {
		// Gửi 5 message đến `consumer-in-topic`
		int start = count.get();
		for (int i = 0; i < 5; i++) {
			bridge.send("consumerKafka-in-0", "Message từ ConsumerComp: " + count.getAndIncrement());
		}
		return "Sent 5 message to `consumer-in-topic` from [" + start + " to " + count.get() + "] at " + new Date();
	}

	@GetMapping("/consumer1")
	public String consumerRequest1() {
		// Gửi 5 message đến `consumer-one-in-topic`
		int start = count.get();
		for (int i = 0; i < 5; i++) {
			bridge.send("consumerKafkaOne-in-0", "Message từ ConsumerComp for ONE: " + count.getAndIncrement());
		}
		return "Sent 5 message to `consumer-one-in-topic` from [" + start + " to " + count.get() + "] at " + new Date();
	}


	@Autowired
	StreamBridge bridge;


	/**
	 * Liên kết với config spring.cloud.stream.bindings.consumerKafka-in-0
	 * ( tên bean này là consumerKafka thì naming convention sẽ là consumerKafka-in-{index} )
	 * Với config batch-mode: true thì kết quả nhận được là 1 List<String> thay vì chỉ là 1 String
	 *
	 * @return
	 */
	@Bean
	Consumer<List<String>> consumerKafka() {
		return list -> {
			log.info("Consumer List<String>: " + list);
		};
	}

	/**
	 * Liên kết với config spring.cloud.stream.bindings.consumerKafkaOne-in-0
	 *
	 * @return
	 */
	@Bean
	Consumer<String> consumerKafkaOne() {
		return str -> {
			log.info("Consumer <String>: " + str);
		};
	}
}
