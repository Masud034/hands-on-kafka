package com.masudulalam.handsonkafka.controller;

import com.masudulalam.handsonkafka.dto.PaymentInfo;
import com.masudulalam.handsonkafka.kafka.JsonKafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final JsonKafkaProducer jsonKafkaProducer;
    public TestController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping(value = "/api/v1/payment-confirmation")
    public void sendConfirmationJson(@RequestBody PaymentInfo paymentInfo) {
        jsonKafkaProducer.sendPaymentConfirmationInfo(paymentInfo);
    }
}
