package com.systems.common.model;

public class PaymentEvent {
    private String paymentId;
    private double amount;
    private String currency;

    // Getters and Setters
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Constructor
    public PaymentEvent(String paymentId, double amount, String currency) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.currency = currency;
    }

    public PaymentEvent() {
    }

    @Override
    public String toString() {
        return "PaymentEvent{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
