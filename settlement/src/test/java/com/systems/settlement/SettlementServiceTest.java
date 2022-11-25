package com.systems.settlement;

import com.systems.common.model.PaymentEvent;
import com.systems.settlement.service.SettlementService;
import org.junit.jupiter.api.Test;

public class SettlementServiceTest {

    @Test
    public void testProcessSettlement(){
        SettlementService settlementService=new SettlementService();

        PaymentEvent paymentEvent = new PaymentEvent();
        paymentEvent.setPaymentId("test-id");
        paymentEvent.setAmount(100.0);
        paymentEvent.setCurrency("USD");

        settlementService.processSettlement(paymentEvent);

    }
}
