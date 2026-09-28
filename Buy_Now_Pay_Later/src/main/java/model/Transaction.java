package model;


import java.time.LocalDateTime;

public class Transaction {
    private double paymentAmount;
    private DuesState duesState;
    private LocalDateTime transactionDate;
    private LocalDateTime dueDate;

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public DuesState getDuesState() {
        return duesState;
    }

    public void setDuesState(DuesState duesState) {
        this.duesState = duesState;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
