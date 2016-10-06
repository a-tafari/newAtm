package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class Account {
    public enum AccountType {CHECKING, SAVINGS, BUSINESS}
    private AccountType type;
    private double acctBalance;
    private int acctNumber;
    private double interestRate;
    private static int acctCounter = 1;
    private int customerID;

    public Account(AccountType type, double acctBalance){
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

        this.acctBalance = acctBalance;


        if (AccountType.SAVINGS.equals(AccountType.SAVINGS)){
            this.interestRate = 0.03;
        } else if (AccountType.BUSINESS.equals(AccountType.BUSINESS)){
            this.interestRate = 0.16;
        }

    }

    public Account(AccountType type, int customerID, double acctBalance){
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
        this.customerID = customerID;
        this.acctBalance = acctBalance;
        this.acctNumber = acctCounter++;
    }

    public Account(){

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

    public double getAcctBalance(){
        return acctBalance;
    }

    public int getCustomerID(){
        return customerID;
    }

    public void withdrawal(double amount){
        acctBalance -= amount;
    }

    public void deposit(double amount){
        acctBalance += amount;
    }
}
