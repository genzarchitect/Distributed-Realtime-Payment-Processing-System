package com.systems.payment.gateway.controller;

import com.systems.common.model.PaymentEvent;
import com.systems.payment.gateway.service.PaymentProcessor;
import com.systems.payment.gateway.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentProcessor paymentProcessor;

    @Autowired
    public PaymentController(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @PostMapping("/payments")
    public ResponseEntity<String> processPayment(@RequestBody PaymentEvent paymentEvent) {
        paymentProcessor.processPaymentAsync(paymentEvent);
        return ResponseEntity.ok("Payment processed successfully");
    }
}

