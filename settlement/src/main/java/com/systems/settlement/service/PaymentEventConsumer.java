package com.systems.settlement.service;

import com.systems.common.model.PaymentEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventConsumer {
    private final SettlementService settlementService;

    private static final Logger logger = LoggerFactory.getLogger(PaymentEventConsumer.class);

    public PaymentEventConsumer(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    @KafkaListener(topics = "processed-transaction-events", groupId = "settlement-group")
    public void consumePaymentEvent(ConsumerRecord<String, PaymentEvent> record) {
        PaymentEvent paymentEvent = record.value();
        logger.info("Received payment event in settlement-group: {}", paymentEvent);
        settlementService.processSettlement(paymentEvent);
    }
}
