package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class Transaction {
    public enum TransType {DEPOSIT, WITHDRAWAL, TRANFER}
    private TransType type;
    private double amount;
    private int userID;
    private int fromAccountNumber;
    private int toAccountNumber;

    public Transaction(TransType type, int userID, int fromAccountNumber, double amount){
        this.type = type;
        this.userID = userID;
        this.fromAccountNumber = fromAccountNumber;
        this.amount = amount;
    }

    public Transaction(int userID, int fromAccountNumber, int toAccountNumber, double amount){
        this.userID = userID;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
    }

    public int getFromAccountNumber(){
        return this.fromAccountNumber;
    }

    public int getToAccountNumber(){
        return this.toAccountNumber;
    }

    public double getAmount(){
        return this.amount;
    }

    public TransType getTransType(){
        return this.type;
    }

    public int getUserID(){
        return this.userID;
    }
}
