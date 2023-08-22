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

import com.example.demo.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
public class FunctionComp {

	Log log = LogFactory.getLog(getClass());

	/**
	 * Biến đổi data dạng String sang Person
	 * String: name|message
	 * Person:
	 * 	+ name
	 * 	+ message
	 * @return
	 */
	@Bean
	public Function<String, Person> functionRabbit() {
		return str ->
		{
			log.info("functionRabbit: Create Person from str: " + str);
			Person person = new Person();
			String[] arrData = str.split("\\|");
			person.setName(arrData[0]);
			person.setMessage(arrData[1]);

			return person;
		};
	}

}
