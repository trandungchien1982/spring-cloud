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
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

@RestController
public class FunctionComp {

	Log log = LogFactory.getLog(getClass());

	/**
	 * StreamBridge này sẽ gửi data đi đến channel nào đó
	 */
	@Autowired
	StreamBridge bridge;

	private static AtomicInteger count = new AtomicInteger();

	@GetMapping("/function")
	public String functionRequest() {
		// Gửi 5 message đến `function-in-topic`
		int start = count.get();
		for (int i = 0; i < 5; i++) {
			bridge.send("functionKafka-in-0", "Message từ FunctionComp: " + count.getAndIncrement());
		}
		return "Sent 5 message to `function-in-topic` from [" + start + " to " + count.get() + "] at " + new Date();
	}

	/**
	 * Khi message được gửi đến `functionKafka-in-0` channel thì nó sẽ được consume & biến đổi data theo mô tả ở đây
	 * 	và data kết quả sẽ được chuyển thẳng đến `functionKafka-out-0`
	 * @return
	 */
	@Bean
	public Function<String, String> functionKafka() {
		return value -> "{Transform}: " + value.toUpperCase();
	}

}
