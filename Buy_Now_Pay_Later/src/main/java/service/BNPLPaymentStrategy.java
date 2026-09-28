package service;

import model.DuesState;
import model.Transaction;
import model.User;

import java.time.LocalDateTime;
import java.util.Calendar;

public class BNPLPaymentStrategy implements PaymentStrategyType {

    @Override
    public Transaction createTransaction(double amount, User user, LocalDateTime date) throws Exception{
        if(user.isIs_blocked()) {
            throw new Exception("User is blocked");
        }
        if(amount > user.getBnpl_limit()){
            user.setIs_blocked(true);
            throw new Exception("Your limit doesn't allow this expenditure");
        }
        Transaction t = new Transaction();
        t.setPaymentAmount(amount);
        t.setDuesState(DuesState.PENDING);
        t.setTransactionDate(date);
        user.setBnpl_limit(user.getBnpl_limit()-amount);
        t.setDueDate(date.plusDays(30));
        return t;
    }
}
