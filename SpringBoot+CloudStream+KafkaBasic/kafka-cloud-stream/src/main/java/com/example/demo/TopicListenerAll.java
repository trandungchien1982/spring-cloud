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
import org.springframework.boot.SpringApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Lắng nghe tất cả các message từ các topics khác nhau
 * (trace log)
 */
@Component
public class TopicListenerAll {

	Log log = LogFactory.getLog(getClass());

	// Bản thân supplierKafka;functionKafka được định nghĩa trong spring.cloud.function.definition
	//	cho nên ta chỉ nhận được data ở bước output sau cùng mà thôi.
	/**
	 * Lắng nghe topic `consumer-in-topic`
	 */
	@KafkaListener(id = "id-Kafka00", topics = "consumer-in-topic")
	public void listenConsumerIn(String message) {
		log.info("Received message from `consumer-in-topic` : " + message);
	}

	/**
	 * Lắng nghe topic `consumer-one-in-topic`
	 */
	@KafkaListener(id = "id-Kafka01", topics = "consumer-one-in-topic")
	public void listenConsumerOneIn(String message) {
		log.info("Received message from `consumer-one-in-topic` : " + message);
	}


	@KafkaListener(id = "id-Kafka03", topics = "function-in-topic")
	public void listenFunctionIn(String message) {
		log.info("Received message from `function-in-topic` : " + message);
	}
	@KafkaListener(id = "id-Kafka04", topics = "function-out-topic")
	public void listenFunctionOut(String message) {
		log.info("Received message from `function-out-topic` : " + message);
	}

	@KafkaListener(id = "id-Kafka05", topics = "supplier-in-topic")
	public void listenSupplierIn(String message) {
		log.info("Received message from `supplier-in-topic` : " + message);
	}
	@KafkaListener(id = "id-Kafka06", topics = "supplier-out-topic")
	public void listenSupplierOut(String message) {
		log.info("Received message from `supplier-out-topic` : " + message);
	}


}
