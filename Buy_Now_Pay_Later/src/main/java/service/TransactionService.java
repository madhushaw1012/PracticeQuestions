package service;

import model.Transaction;
import model.User;
import repository.TransactionRepository;

import java.time.LocalDateTime;

public class TransactionService {

    TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(double price, User user, PaymentStrategyType paymentStrategyType, LocalDateTime date) throws Exception {
        return paymentStrategyType.createTransaction(price,user,date);
    }

    public void addTransaction(Transaction t) throws Exception {
        transactionRepository.addTransaction(t);
    }
}
