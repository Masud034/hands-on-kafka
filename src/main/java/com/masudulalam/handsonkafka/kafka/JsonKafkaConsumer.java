package com.masudulalam.handsonkafka.kafka;

import com.masudulalam.handsonkafka.dto.PaymentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class JsonKafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    @KafkaListener(topics = "Payment-Confirmation", groupId = "group-1")
    public void consume(PaymentInfo paymentInfo) {
        logger.info(paymentInfo.getCustomerName());
    }
}
