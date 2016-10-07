package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class Atm {

    private Transaction transaction;
    private UserInfo currentCustomer;
    private Account account;
    private UserInput userInput;
    private Display display;
    private boolean isRunning;
    private UserManagement userManager;
    private ManageAccount manageAccount;
    private ManageTransaction manageTransaction;
    private int currentCustomerID;



    public Atm(){
        manageAccount = new ManageAccount();
        userManager = new UserManagement();
        display = new Display();
        isRunning = true;
        manageTransaction = new ManageTransaction();
        userInput = new UserInput();

    }

    public void createNewUser(){
        System.out.print("PLEASE ENTER YOUR NAME: ");
        String userName = userInput.getUserString();
        System.out.print("PLEASE CHOOSE A FOUR DIGIT PIN: ");
        int userPin = userInput.getUserInt();
        userManager.addUser(userName, userPin);
        System.out.println("ACCOUNT WAS SUCCESSFULLY CREATED: ");
        display.newAccountMenu();
        generateNewAccount();
    }

    public void accessCustomerAccount(){
        display.printReturningCustomerMenu();
        int userChoice = userInput.getUserInt();

        switch (userChoice){
            case 1: // deposit
                System.out.print("ENTER ACCOUNT NUMBER");
                int accountNumber = userInput.getUserInt();
                System.out.print("AMOUNT TO DEPOSIT: ");
                double depositAmount = userInput.getUserDouble();
                deposit(currentCustomerID, accountNumber, depositAmount);
                System.out.println("DEPOSIT OF $" + depositAmount + " WAS SUCCESSFUL!");
                System.out.println("YOUR NEW BALANCE IS: " + manageAccount.getAccount(currentCustomerID, accountNumber).getBalance());
                display.printReturningCustomerMenu();
                break;
            case 2: // withdrawal
                System.out.print("ENTER ACCOUNT NUMBER");
                int accountNumber1 = userInput.getUserInt();
                System.out.print("AMOUNT TO WITHDRAW: ");
                double withdrawalAmount = userInput.getUserDouble();
                deposit(currentCustomerID, accountNumber1, withdrawalAmount);
                System.out.print("WITHDRAWAL OF $" + withdrawalAmount + " WAS SUCCESSFUL!");
                System.out.print("YOUR NEW BALANCE IS: " + manageAccount.getAccount(currentCustomerID, accountNumber1).getBalance());
                display.printReturningCustomerMenu();
                break;
            case 3: // transfer
                System.out.print("ENTER FROM ACCOUNT NUMBER: ");
                int fromAccountNumber = userInput.getUserInt();
                System.out.print("TO ACCOUNT NUMBER: ");
                int toAccountNumber = userInput.getUserInt();
                System.out.print("ENTER AMOUNT TO TRANSFER: $");
                double amountToTransfer = userInput.getUserDouble();
                Account fromAccount = manageAccount.getAccount(currentCustomerID, fromAccountNumber);
                Account toAccount = manageAccount.getAccount(currentCustomerID, toAccountNumber);
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
                int closingAccountNumber = userInput.getUserInt();
                manageAccount.deleteAccount(currentCustomerID,closingAccountNumber);
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

    public Boolean verifyLoginInfo(int userID, int pinNumber){
        if (userManager.getUser(userID).getUserID() == userID){
            if (userManager.getUser(userID).getPin() == pinNumber){
                currentCustomerID = userID;
                return true;
            }
        }
        return false;

    }

    public void withdrawal(int customerID, int accountNum, double amount){
        Account account = manageAccount.getAccount(customerID, accountNum);
        account.withdrawal(amount);
    }

    public void deposit(int customerID, int accountNum, double amount){
        Account account = manageAccount.getAccount(customerID, accountNum);
        account.deposit(amount);
    }

    public void transfer(int customerID, int accountNumFrom, int accountNumTo, double amount){

    }

    public void closeAccount(int customerID, int accountNumber){
        if (isAccountBalanceZero(customerID, accountNumber)) {
            manageAccount.deleteAccount(currentCustomerID, accountNumber);
        }
    }

    public void startAtm(){
        while(isRunning){
            display.printWelcomeSCreen();
            display.generalMenu();


            int userChoice = userInput.getUserInt();
            switch (userChoice){
                case 1:
                    createNewUser();
                    break;
                case 2:
                    display.printLogin();
                    System.out.print("Please enter customer ID number: ");
                    int returningUserAccountNumber = userInput.getUserInt();
                    System.out.print("Please enter pin: ");
                    int returnUserPinNumber = userInput.getUserInt();
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
        if (manageAccount.getAccount(customerID, accountNumber).getBalance() != 0 ){
            return false;
        }
        return true;
    }

    public void generateNewAccount(){
        System.out.print("SELECT AN OPTION: ");
        int userChoice = userInput.getUserInt();
        Account account = null;
        double initialDeposit;
        switch (userChoice){
            case 1:
                initialDeposit = getInitialDeposit();
                manageAccount.addAccount(Account.AccountType.CHECKING, currentCustomerID, initialDeposit);
                System.out.println("ACCOUNT SUCCESSFULLY CREATED");
                display.printReturningCustomerMenu();
                break;
            case 2:
                initialDeposit = getInitialDeposit();
                manageAccount.addAccount(Account.AccountType.SAVINGS, currentCustomerID, initialDeposit);
                System.out.println("ACCOUNT SUCCESSFULLY CREATED");
                display.printReturningCustomerMenu();
                break;
            case 3:
                initialDeposit = getInitialDeposit();
                manageAccount.addAccount(Account.AccountType.BUSINESS, currentCustomerID, initialDeposit);
                System.out.println("ACCOUNT SUCCESSFULLY CREATED");
                display.printReturningCustomerMenu();
                break;
        }
    }

    public double getInitialDeposit(){
        System.out.print("ENTER DEPOSIT AMOUNT: ");
        double deposit = userInput.getUserDouble();
        return deposit;
    }

    public double getAccountBalance(int customerID, int accountNumber){
        double userBalance = manageAccount.getAccount(customerID, accountNumber).getBalance();
        return userBalance;
    }


}
