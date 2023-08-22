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

import com.example.demo.model.Teacher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
public class ConsumerComp {

	Log log = LogFactory.getLog(getClass());

	/**
	 * Nhận message Teacher từ Kafka trong topic
	 * 	rồi gửi qua Kafka
	 * 	* @return
	 */
	@Bean
	public Consumer<Teacher> teacherConsumer() {
		return teacher ->
		{
			log.info("teacherConsumer in App3+Kafka01: Get Teacher: " + teacher);
		};
	}

}
