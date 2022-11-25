package com.systems.transaction.processing.service;

import com.systems.common.model.PaymentEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventConsumer {

    private final TransactionProcessor transactionProcessor;

    private static final Logger logger = LoggerFactory.getLogger(PaymentEventConsumer.class);

    public PaymentEventConsumer(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }

    @KafkaListener(topics = "payment-events", groupId = "transaction-processing-group")
    public void consumePaymentEvent(ConsumerRecord<String, PaymentEvent> record) {
        PaymentEvent paymentEvent = record.value();
        logger.info("Received payment event in transaction-processing-group: {}", paymentEvent);
        transactionProcessor.processTransaction(paymentEvent);
    }
}

