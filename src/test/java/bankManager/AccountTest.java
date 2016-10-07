package bankManager;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
/**
 * Created by abijah on 10/6/16.
 */
public class AccountTest {



    @Test
    public void setTypeTest(){//checks for the account "Type"
        Account account = new Account(Account.AccountType.CHECKING, 10.00);
        Account.AccountType expected = Account.AccountType.CHECKING;
        Account.AccountType actual = account.getType();
        Assert.assertEquals("Should return Type.CHECKING", expected, actual);

    }

    @Test
    public void getTypeTest(){
        Account account = new Account(Account.AccountType.CHECKING, 10.00);// sets account type and gets account type
        account.setType(Account.AccountType.BUSINESS);
        Account.AccountType expected = Account.AccountType.BUSINESS;
        Account.AccountType actual = account.getType();
        Assert.assertEquals("Should return BUSINESS",expected, actual);//test to see if accounts are the same
    }

    @Test
    public void getAccountNumberTest(){

       Account account = new Account(Account.AccountType.CHECKING, 100.00);
        int actual = account.getAcctNumber();
        int expected = 2;
        Assert.assertEquals("Should return 2", expected, actual);

    }

    @Test
    public void getInterestRateTest(){

        Account account = new Account(Account.AccountType.BUSINESS, 500.00);
        double actual = account.getInterestRate();
        double expected = 0.12;
        Assert.assertEquals("Should return 0.12", expected, actual, .05);
    }
}
