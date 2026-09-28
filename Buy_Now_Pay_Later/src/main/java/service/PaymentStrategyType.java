package service;

import model.Transaction;
import model.User;

import java.time.LocalDateTime;


public interface PaymentStrategyType {
    Transaction createTransaction(double amount, User user, LocalDateTime date) throws Exception;
}
