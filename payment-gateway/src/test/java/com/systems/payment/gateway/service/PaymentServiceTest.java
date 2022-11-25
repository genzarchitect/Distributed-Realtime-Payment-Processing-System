package com.systems.payment.gateway.service;

import com.systems.common.model.PaymentEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.kafka.core.KafkaTemplate;

public class PaymentServiceTest {

    @Test
    public void testProcessPayment(){

        // Mock kafkaTemplate
        KafkaTemplate<String, PaymentEvent> kafkaTemplate = Mockito.mock(KafkaTemplate.class);
        PaymentService paymentService=new PaymentService(kafkaTemplate);

        PaymentEvent paymentEvent = new PaymentEvent();
        paymentEvent.setPaymentId("test-id");
        paymentEvent.setAmount(100.0);
        paymentEvent.setCurrency("USD");

        paymentService.processPayment(paymentEvent);
        Mockito.verify(kafkaTemplate).send("payment-events", paymentEvent);

    }
}
