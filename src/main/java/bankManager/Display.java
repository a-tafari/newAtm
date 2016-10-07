package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class Display {
    public void printWelcomeSCreen(){
        System.out.println("WELCOME TO BANK TAFARI");
    }

    public void generalMenu(){

        System.out.println(" [1] NEW CUSTOMER   ");
        System.out.println(" [2] RETURNING CUSTOMER");
        System.out.println(" [3] LOG OUT ");

    }

    public void newCusomterMenu(){

        System.out.println("           WELCOME              ");
        System.out.println("    PLEASE ENTER YOUR NAME      ");
        System.out.println("    AND NEW PIN NUMBER         ");
        System.out.println("            BELOW              ");
    }


    public void newAccountMenu(){

        System.out.println(" [1] OPEN CHECKING ACCOUNT  ");
        System.out.println(" [2] OPEN SAVINGS ACCOUNT  ");
        System.out.println(" [3] OPEN BUSINESS ACCOUNT");
        System.out.println(" [4] LOG OUT ");

    }

    public void printLogin(){

        System.out.println("  ENTER ACCT INFO  ");

    }

    public void printReturningCustomerMenu(){

        System.out.println(" [1] DEPOSIT   ");
        System.out.println(" [2] WITHDRAWAL  ");
        System.out.println(" [3] TRANSFER ");
        System.out.println(" [4] OPEN NEW ACCOUNT   ");
        System.out.println(" [5] CLOSE ACCOUNT   ");
        System.out.println(" [6] VIEW TRANSACTIONS   ");
        System.out.println(" [7] EXIT        ");
    }

    public void printTransactionsMenu(){
        System.out.println("[1] VIEW TRANSACTIONS   ");
        System.out.println("[2] LOG OUT    ");
    }

}
