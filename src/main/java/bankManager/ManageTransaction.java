package bankManager;

import java.util.ArrayList;

/**
 * Created by abijah on 10/6/16.
 */
public class ManageTransaction {
    private ArrayList<Transaction> transactionList;

    public ManageTransaction(){
        transactionList = new ArrayList<Transaction>();
    }

    public void addTransaction(Transaction.TransType transactionType, int userId, int accountNumber, double amount){
        transactionList.add(new Transaction(transactionType, userId, accountNumber, amount));
    }

    public void addTransaction( int userID, int fromAccountNumber, int toAccountNumber, double amount){
        transactionList.add(new Transaction(userID, fromAccountNumber, toAccountNumber, amount));
    }

    public String printTransaction(int userID){
        for (Transaction transactions: transactionList){
            System.out.println("UserID: " + transactions.getUserID() + " | " + "Account Number: " +
                    transactions.getFromAccountNumber() + " | " + "Amount: " + transactions.getAmount() +
                    " | " + transactions.getTransType());
        }
        return null;
    }

    public Transaction getTransaction(int userID){
        for (Transaction transactions: transactionList){
            if (transactions.getUserID() == userID){
                return transactions;
            }
        }
        return null;
    }
}
