package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class Atm {

    private Transaction transaction;
    private Customer currentCustomer;
    private Account account;
    private UserInputHandler userInputHandler;
    private Display display;
    private boolean isRunning;
    private CustomerManager customerManager;
    private AccountManager accountManager;
    private TransactionManager transactionManager;
    private int currentCustomerID;



    public ATM(){
        accountManager = new AccountManager();
        customerManager = new CustomerManager();
        display = new Display();
        isRunning = true;
        transactionManager = new TransactionManager();
        userInputHandler = new UserInputHandler();

    }

    public void createNewCustomer(){
        System.out.print("PLEASE ENTER YOUR NAME: ");
        String userName = userInputHandler.getUserString();
        System.out.print("PLEASE CHOOSE A FOUR DIGIT PIN: ");
        int userPin = userInputHandler.getUserInt();
        customerManager.addCustomer(userName, userPin);
        System.out.println("ACCOUNT WAS SUCCESSFULLY CREATED: ");
        display.newAccountMenu();
        generateNewAccount();
    }

    public void accessCustomerAccount(){
        display.printReturningCustomerMenu();
        int userChoice = userInputHandler.getUserInt();

        switch (userChoice){
            case 1: // deposit
                System.out.print("ENTER ACCOUNT NUMBER");
                int accountNumber = userInputHandler.getUserInt();
                System.out.print("AMOUNT TO DEPOSIT: ");
                double depositAmount = userInputHandler.getUserDouble();
                deposit(currentCustomerID, accountNumber, depositAmount);
                System.out.println("DEPOSIT OF $" + depositAmount + " WAS SUCCESSFUL!");
                System.out.println("YOUR NEW BALANCE IS: " + accountManager.getAccount(currentCustomerID, accountNumber).getBalance());
                display.printReturningCustomerMenu();
                break;
            case 2: // withdrawal
                System.out.print("ENTER ACCOUNT NUMBER");
                int accountNumber1 = userInputHandler.getUserInt();
                System.out.print("AMOUNT TO WITHDRAW: ");
                double withdrawalAmount = userInputHandler.getUserDouble();
                deposit(currentCustomerID, accountNumber1, withdrawalAmount);
                System.out.print("WITHDRAWAL OF $" + withdrawalAmount + " WAS SUCCESSFUL!");
                System.out.print("YOUR NEW BALANCE IS: " + accountManager.getAccount(currentCustomerID, accountNumber1).getBalance());
                display.printReturningCustomerMenu();
                break;
            case 3: // transfer
                System.out.print("ENTER FROM ACCOUNT NUMBER: ");
                int fromAccountNumber = userInputHandler.getUserInt();
                System.out.print("TO ACCOUNT NUMBER: ");
                int toAccountNumber = userInputHandler.getUserInt();
                System.out.print("ENTER AMOUNT TO TRANSFER: $");
                double amountToTransfer = userInputHandler.getUserDouble();
                Account fromAccount = accountManager.getAccount(currentCustomerID, fromAccountNumber);
                Account toAccount = accountManager.getAccount(currentCustomerID, toAccountNumber);
                transfer(currentCustomerID, fromAccountNumber, toAccountNumber, amountToTransfer);
                System.out.println("TRANSFER SUCCESSFUL!");
                System.out.println("$" + amountToTransfer + " WAS SUCCESSFULLY TRANSFERRED FROM ACCT #" + fromAccount
                        + " TO ACCT #" + toAccount);
                display.printReturningCustomerMenu();
                break;
            case 4: // open new account
                generateNewAccount();
                break;
            case 5: // close account
                System.out.print("PLEASE ENTER YOUR ACCOUNT NUMBER: ");
                int closingAccountNumber = userInputHandler.getUserInt();
                accountManager.deleteAccount(currentCustomerID,closingAccountNumber);
                display.printReturningCustomerMenu();
                break;
            case 6: // view transactions
                break;
            case 7: // exit
                break;
        }

    }

    public void exitProgram(){
        isRunning = false;
    }

    public void logIN(){

    }

    public void logOUT(){

    }

    public Boolean verifyLoginInfo(int customerID, int pinNumber){
        if (customerManager.getCustomer(customerID).getCustomerID() == customerID){
            if (customerManager.getCustomer(customerID).getPin() == pinNumber){
                currentCustomerID = customerID;
                return true;
            }
        }
        return false;

    }

    public void withdrawal(int customerID, int accountNum, double amount){
        Account account = accountManager.getAccount(customerID, accountNum);
        account.withdrawal(amount);
    }

    public void deposit(int customerID, int accountNum, double amount){
        Account account = accountManager.getAccount(customerID, accountNum);
        account.deposit(amount);
    }

    public void transfer(int customerID, int accountNumFrom, int accountNumTo, double amount){

    }

    public void closeAccount(int customerID, int accountNumber){
        if (isAccountBalanceZero(customerID, accountNumber)) {
            accountManager.deleteAccount(currentCustomerID, accountNumber);
        }
    }

    public void startATM(){
        while(isRunning){
            display.printWelcomeSCreen();
            display.generalMenu();


            int userChoice = userInputHandler.getUserInt();
            switch (userChoice){
                case 1:
                    createNewCustomer();
                    break;
                case 2:
                    display.printLogin();
                    System.out.print("Please enter customer ID number: ");
                    int returningUserAccountNumber = userInputHandler.getUserInt();
                    System.out.print("Please enter pin: ");
                    int returnUserPinNumber = userInputHandler.getUserInt();
                    if (verifyLoginInfo(returningUserAccountNumber, returnUserPinNumber)){
                        display.printReturningCustomerMenu();
                    } else {
                        System.out.println("INCORRECT LOGIN INFORMATION");
                        display.printLogin();
                    }

            }
        }
    }

    public Boolean isAccountBalanceZero(int customerID, int accountNumber){
        if (accountManager.getAccount(customerID, accountNumber).getBalance() != 0 ){
            return false;
        }
        return true;
    }

    public void generateNewAccount(){
        System.out.print("PLEASE CHOOSE AN OPTION: ");
        int userChoice = userInputHandler.getUserInt();
        Account account = null;
        double initialDeposit;
        switch (userChoice){
            case 1:
                initialDeposit = getInitialDeposit();
                accountManager.addAccount(Account.AccountType.CHECKING, currentCustomerID, initialDeposit);
                System.out.println("ACCOUNT SUCCESSFULLY CREATED");
                display.printReturningCustomerMenu();
                break;
            case 2:
                initialDeposit = getInitialDeposit();
                accountManager.addAccount(Account.AccountType.SAVINGS, currentCustomerID, initialDeposit);
                System.out.println("ACCOUNT SUCCESSFULLY CREATED");
                display.printReturningCustomerMenu();
                break;
            case 3:
                initialDeposit = getInitialDeposit();
                accountManager.addAccount(Account.AccountType.BUSINESS, currentCustomerID, initialDeposit);
                System.out.println("ACCOUNT SUCCESSFULLY CREATED");
                display.printReturningCustomerMenu();
                break;
        }
    }

    public double getInitialDeposit(){
        System.out.print("ENTER INITIAL DEPOSIT AMOUNT: ");
        double deposit = userInputHandler.getUserDouble();
        return deposit;
    }

    public double getAccountBalance(int customerID, int accountNumber){
        double userBalance = accountManager.getAccount(customerID, accountNumber).getBalance();
        return userBalance;
    }

    public void accountTypeOptions(){

    }
}
