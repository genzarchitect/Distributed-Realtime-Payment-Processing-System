package com.systems.payment.gateway.service;

import com.systems.common.model.PaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    @Autowired
    public PaymentService(KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void processPayment(PaymentEvent paymentEvent) {
        // Validate payment event
        validatePayment(paymentEvent);

        // Authorize payment
        authorizePayment(paymentEvent);

        // Business logic to process payment
        System.out.println("Processing payment: " + paymentEvent.getPaymentId());

        // Send payment event to Kafka
        kafkaTemplate.send("payment-events", paymentEvent);
    }

    private void validatePayment(PaymentEvent paymentEvent) {
        // validation logic, such as checking the amount, currency, etc.
        if (paymentEvent.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid payment amount");
        }
    }

    private void authorizePayment(PaymentEvent paymentEvent) {
        // authorization logic, such as checking user balance, credit limits, etc.
        System.out.println("Authorizing payment: " + paymentEvent.getPaymentId());
    }
}

