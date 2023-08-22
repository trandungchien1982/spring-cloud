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
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {

    Log log = LogFactory.getLog(getClass());

    private static AtomicInteger count = new AtomicInteger();

    /**
     * StreamBridge này sẽ gửi data đi đến channel nào đó
     */
    @Autowired
    StreamBridge bridge;

    @GetMapping("/send-message")
    public String messageRequest() {
        // Gửi 7 message đến `begin-rabbit-topic`
        int start = count.get();
        for (int i = 1; i <= 7; i++) {
            int curVal = count.getAndIncrement();
            bridge.send("functionRabbit-in-0", "Name" + curVal + "|Message từ App1 - RabbitMQ: " + curVal);
        }
        return "Sent message to `begin-rabbit-topic` from [" + start + " to " + count.get() + "] at " + new Date();
    }

}
