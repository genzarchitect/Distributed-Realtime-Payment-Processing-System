package com.systems.payment.gateway.service;

import com.systems.common.model.PaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class PaymentProcessor {
    private static final int THREAD_POOL_SIZE = 10;
    private ExecutorService executorService;

    @Autowired
    private PaymentService paymentService;

    public PaymentProcessor(){
        // create a fixed size thread pool
        executorService= Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public void processPaymentAsync(PaymentEvent paymentEvent){
        // submit task to the thread pool for asynchronous processing
        executorService.submit(() -> {
            // Perform payment processing logic asynchronously
            processPayment(paymentEvent);
        });
    }

    private void processPayment(PaymentEvent paymentEvent){
        try{
            // Save payment event using the service which handles transaction
            paymentService.processPayment(paymentEvent);

            // Log successful processing
            System.out.println("Processed payment: " + paymentEvent.getPaymentId());
        }catch(Exception e){
            // Handle exceptions and rollback if necessary
            System.err.println("Failed to process payment: " + e.getMessage());
        }
    }
}
