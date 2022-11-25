package com.systems.settlement.service;

import com.systems.common.model.PaymentEvent;
import com.systems.settlement.model.Settlement;
import com.systems.settlement.repository.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SettlementService {

    private final SettlementRepository settlementRepository;

    @Autowired
    public SettlementService(SettlementRepository settlementRepository) {
        this.settlementRepository = settlementRepository;
    }

    @Transactional
    public void processSettlement(PaymentEvent paymentEvent) {
        // Business logic to handle settlement...
        System.out.println("Processing settlement for payment ID: " + paymentEvent.getPaymentId());

        // Save settlement data to the PostgreSQL database
        Settlement settlement = new Settlement();
        settlement.setPaymentId(paymentEvent.getPaymentId());
        settlement.setAmount(paymentEvent.getAmount());
        settlement.setCurrency(paymentEvent.getCurrency());
        settlement.setStatus("COMPLETED"); // Example status, update based on your logic

        settlementRepository.save(settlement);
    }
}

