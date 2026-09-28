package repository;

import model.DuesState;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    List<Transaction> clearedTransactions;
    List<Transaction> unclearedtransactions;

    public TransactionRepository() {
        clearedTransactions=new ArrayList<Transaction>();
        unclearedtransactions= new ArrayList<Transaction>();
    }

    public void addTransaction(Transaction t) throws Exception {
        if(t.getDuesState()== DuesState.CLEARED) { clearedTransactions.add(t);}
        else unclearedtransactions.add(t);
    }

}
