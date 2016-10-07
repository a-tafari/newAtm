package bankManager;

import java.util.ArrayList;

/**
 * Created by abijah on 10/6/16.
 */
public class ManageAccount {
    private ArrayList<Account> accountList;


    public ManageAccount(){
        this.accountList = new ArrayList<Account>();
    }

    public void addAccount(Account.AccountType accountType,int userID, double balance){//Adds a new account by calling the account class
        accountList.add(new Account(accountType, userID, balance));//creates a new account object and adds input to the parameters
    }

    public Account getAccount(int userID, int accountNumber){//checks user ID and Account input  to see if it matches the users account in array list
        for (Account account: accountList){
            if ((account.getUserID() == userID) && (account.getAcctNumber() == accountNumber)){
                return account;
            }
        }
        return null;
    }

    public void deleteAccount(int userID, int accountNumber){
        for (Account account: accountList){
            if (account.getUserID() == userID & account.getAcctNumber() == accountNumber){
                accountList.remove(account);
                return;
            }
        }
        System.out.println("No Account Found, Please Try Again.");

    }

}
