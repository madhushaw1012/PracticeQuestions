package service;

import model.DuesState;
import model.Transaction;
import model.User;

import java.time.LocalDateTime;


public class PrepaidPaymentStrategy implements PaymentStrategyType {
    @Override
    public Transaction createTransaction(double amount, User user, LocalDateTime date) throws Exception{

        Transaction t = new Transaction();
        t.setDuesState(DuesState.CLEARED);
        t.setDueDate(date);
        t.setTransactionDate(date);
        t.setPaymentAmount(amount);
        return t;
    }
}
