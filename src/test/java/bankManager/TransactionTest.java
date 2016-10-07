package bankManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by abijah on 10/6/16.
 */
public class TransactionTest {
    Transaction transaction= new Transaction(Transaction.TransType.DEPOSIT, 2, 4, 5000);


    @Before

    @Test
    public void getAccountNumberTest(){
        int actual = transaction.getFromAccountNumber();
        int expected = 4;
        Assert.assertEquals("Should return 4", expected, actual);
    }

    @Test
    public void getUserIDTest(){
        int actual = transaction.getUserID();
        int expected = 2;
        Assert.assertEquals("Should return 2", expected, actual);
    }

    @Test
    public void getAmountTest(){
        double actual = transaction.getAmount();
        double expected = 5000;
        Assert.assertEquals("Should return 5000", expected, actual, 0);
    }
/*
    @Test
    public void getTransActionTypeTest(){
        Transaction.TransType actual = transaction.getTransType();
        Transaction.TransType expected = Transaction.TransType.DEPOSIT;
        Assert.assertEquals("Should return 5000", expected, actual,0);
    }*/
}
