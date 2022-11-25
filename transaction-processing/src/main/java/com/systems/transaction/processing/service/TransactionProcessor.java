package com.systems.transaction.processing.service;

import com.systems.common.model.PaymentEvent;
import com.systems.transaction.processing.model.ProcessedTransaction;
import com.systems.transaction.processing.model.ProcessedTransactionEvent;
import com.systems.transaction.processing.repository.ProcessedTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProcessor {

    private final KafkaTemplate<String, ProcessedTransactionEvent> kafkaTemplate;

    private final ProcessedTransactionRepository processedTransactionRepository;

    @Autowired
    public TransactionProcessor(KafkaTemplate<String, ProcessedTransactionEvent> kafkaTemplate,
                                ProcessedTransactionRepository processedTransactionRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.processedTransactionRepository = processedTransactionRepository;
    }

    public void processTransaction(PaymentEvent paymentEvent) {
        // Business logic to process transaction...
        System.out.println("Processing transaction for payment ID: " + paymentEvent.getPaymentId());

        // Save processed transaction to MongoDB
        ProcessedTransaction processedTransaction = new ProcessedTransaction(
                paymentEvent.getPaymentId(), paymentEvent.getAmount(), paymentEvent.getCurrency(), "Processed");
        processedTransactionRepository.save(processedTransaction);

        // Create a processed transaction event
        ProcessedTransactionEvent processedTransactionEvent = new ProcessedTransactionEvent(paymentEvent.getPaymentId(), paymentEvent.getAmount(), paymentEvent.getCurrency());

        // publish the processed transaction event to kafka
        kafkaTemplate.send("processed-transaction-events", processedTransactionEvent);
    }
}
