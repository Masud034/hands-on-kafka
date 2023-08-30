package com.masudulalam.handsonkafka.controller;

import com.masudulalam.handsonkafka.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final KafkaProducer kafkaProducer;
    public TestController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping(value = "/api/v1/payment-confirmation")
    public void sendConfirmation(@RequestParam String message) {
        kafkaProducer.sendPaymentConfirmationInfo(message);
    }
}
