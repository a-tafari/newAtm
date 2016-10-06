package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class ManageAccount {
    private ArrayList<Account> accountList;


    public AccountManager(){
        this.accountList = new ArrayList<Account>();
    }

    public void addAccount(Account.AccountType accountType,int customerID, double balance){
        accountList.add(new Account(accountType, customerID, balance));
    }

    public Account getAccount(int customerID, int accountNumber){
        for (Account account: accountList){
            if ((account.getCustomerID() == customerID) && (account.getAcctNumber() == accountNumber)){
                return account;
            }
        }
        return null;
    }

    public void deleteAccount(int customerID, int accountNumber){
        for (Account account: accountList){
            if (account.getCustomerID() == customerID & account.getAcctNumber() == accountNumber){
                accountList.remove(account);
                return;
            }
        }
        System.out.println("THE ACCOUNT THAT YOU REQUESTED TO DELETE DOES NOT EXIST");

    }

}
