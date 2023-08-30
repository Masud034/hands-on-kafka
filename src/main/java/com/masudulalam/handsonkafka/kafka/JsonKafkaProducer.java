package com.masudulalam.handsonkafka.kafka;

import com.masudulalam.handsonkafka.dto.PaymentInfo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, PaymentInfo> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, PaymentInfo> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentConfirmationInfo(PaymentInfo paymentInfo) {
        logger.info("Sending Payment Info To The Broker");
        kafkaTemplate.send("Payment-Confirmation", paymentInfo);
    }
}
