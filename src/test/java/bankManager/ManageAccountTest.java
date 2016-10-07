package bankManager;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;



/**
 * Created by abijah on 10/6/16.
 */
public class ManageAccountTest {
    ManageAccount am = new ManageAccount();

    @Before

    @Test
    public void addAccountTest() {// checks to make sure that when we add an account it isn't empty.

        am.addAccount(Account.AccountType.CHECKING, 1, 500);
        Assert.assertNotNull(am.getAccount(1, 1).getBalance());//not empty
    }


    @Test
    public void getAccountTest() {

        am.addAccount(Account.AccountType.CHECKING, 1, 100.00);// add an account with a balance
        double expected = 100.00;
        double actual = am.getAccount(1, 1).getBalance();//get the account and balance
        Assert.assertEquals("Should return ", expected, actual, 0);
    }

    @Test
    public void deleteAccountTest() {

        am.addAccount(Account.AccountType.BUSINESS, 1, 10);// add a business account
        am.addAccount(Account.AccountType.CHECKING, 1, 100);//adds a checking account
        am.deleteAccount(1, 1);//call the delete method which should delete user id 1 and account number 1
        Account expected = null;
        Account actual = am.getAccount(1, 1);
        Assert.assertEquals("Should return null", expected, actual);


    }
}


