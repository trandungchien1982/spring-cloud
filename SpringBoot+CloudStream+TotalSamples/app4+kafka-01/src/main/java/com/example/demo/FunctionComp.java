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
import com.example.demo.model.Teacher2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
public class FunctionComp {

	Log log = LogFactory.getLog(getClass());

	/**
	 * Nhận message Teacher từ Kafka trong topic `start-kafka-topic` và biến đổi data thành Teacher2
	 * Sau đó sẽ đẩy vào topic `end-kafka-topic`
	 * 	* @return
	 */
	@Bean
	public Function<Teacher, Teacher2> functionConvertTeacher2() {
		return teacher ->
		{
			log.info("functionConvertTeacher2 in App4+Kafka01: Create Teacher2 from Teacher: " + teacher);

			Teacher2 teacher2 = new Teacher2();
			teacher2.setName2("II-" + teacher.getName());
			teacher2.setMessage2("II-" + teacher.getMessage());
			teacher2.setAge2(20 + teacher.getAge());
			teacher2.setClassName2("II-" + teacher.getClassName());

			return teacher2;
		};
	}

}
