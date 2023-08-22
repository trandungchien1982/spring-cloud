package com.example.demo.interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * Tạo ra Interceptor để xử lý quá trình gửi message
 */
@Configuration
public class CustomConfig {

    Log log = LogFactory.getLog(getClass());

    @Bean
    @GlobalChannelInterceptor(patterns = "*")
    public ChannelInterceptor customInterceptor() {
        return new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                log.info("preSend message: " + message.getPayload() + " on channel: " + channel);
                return message;
            }
        };
    }
}
