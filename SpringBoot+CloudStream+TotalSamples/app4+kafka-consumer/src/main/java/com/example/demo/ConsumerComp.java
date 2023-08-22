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

import com.example.demo.model.Teacher2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
public class ConsumerComp {

	Log log = LogFactory.getLog(getClass());

	/**
	 * Nhận message Teacher2 từ Kafka trong topic `end-kafka-topic`
	 * và xử lý
	 */
	@Bean
	public Consumer<Teacher2> consumerTeacher2() {
		return teacher2 ->
		{
			log.info("consumerTeacher2 in App4+Kafka+Consumer: Received Teacher2: " + teacher2);

			// TODO: ...
		};
	}

}
