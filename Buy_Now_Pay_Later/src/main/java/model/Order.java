package model;

import service.PaymentStrategyType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    public String orderId;
    public User userId;
    public PaymentStrategyType paymentType;
    public LocalDateTime orderDate;
    public Transaction transaction;
    public Item item;

    public Order(User userId, Item item, LocalDateTime orderDate, PaymentStrategyType paymentType, Transaction transaction  ) {
        this.orderDate = orderDate;
        this.item = item;
        this.paymentType = paymentType;
        this.userId = userId;
        this.transaction = transaction;
        this.orderId = UUID.randomUUID().toString();
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderLocalDateTime(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PaymentStrategyType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentStrategyType paymentType) {
        this.paymentType = paymentType;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
