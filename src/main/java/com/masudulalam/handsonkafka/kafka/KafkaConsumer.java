package com.masudulalam.handsonkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;

@Configuration
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "Payment-Confirmation", groupId = "group-1")
    public void consume(String message) {
        logger.info("Received : "+message);
    }
}
