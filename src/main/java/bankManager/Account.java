package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class Account {//holds everything an account should have
    public enum AccountType {CHECKING, SAVINGS, BUSINESS}
    private AccountType type;
    private double balance;
    private int acctNumber;
    private double interestRate;
    private static int acctCounter = 1;
    private int userID;

    public Account(AccountType type, double balance){
        switch (type){
            case CHECKING:
                this.type = AccountType.CHECKING;
                break;
            case SAVINGS:
                this.type = AccountType.SAVINGS;
                break;
            case BUSINESS:
                this.type = AccountType.BUSINESS;
        }

        this.balance = balance;


        if (AccountType.SAVINGS.equals(AccountType.SAVINGS)){
            this.interestRate = 0.03;
        } else if (AccountType.BUSINESS.equals(AccountType.BUSINESS)){
            this.interestRate = 0.16;
        }

    }

    public Account(AccountType type, int userID, double acctBalance){//account constructor takes an Act type, a user id and balance
        switch (type){
            case CHECKING:
                this.type = AccountType.CHECKING;
                break;
            case SAVINGS:
                this.type = AccountType.SAVINGS;
                break;
            case BUSINESS:
                this.type = AccountType.BUSINESS;
        }
        this.userID = userID;  // sets user ID
        this.balance = acctBalance; //sets acct
        this.acctNumber = acctCounter++;//increments the counter
    }


    public void setType(AccountType type){
        switch (type) {
            case CHECKING:
                this.type = AccountType.CHECKING;
                break;
            case SAVINGS:
                this.type = AccountType.SAVINGS;
                break;
            case BUSINESS:
                this.type = AccountType.BUSINESS;
        }
    }

    public AccountType getType(){
        return this.type;
    }

    public int getAcctNumber(){
        return acctNumber;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public double getBalance(){
        return balance;
    }

    public int getUserID(){
        return userID;
    }

    public void withdrawal(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;
    }
}
