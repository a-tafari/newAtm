package bankManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by abijah on 10/6/16.
 */
public class UserManagementTest {

    UserManagement um = new UserManagement();


    @Before



    @Test
    public void getUserTest(){
        um.addUser("Abijah", 2525);
        String expected = "Abijah";
        String actual = um.getUser(1).getName();
        Assert.assertEquals("Should return Tom Brady", expected, actual);
    }

    @Test
    public void addUserTest(){
        um.addUser("Abijah", 2525);
        Assert.assertNotNull(um.getUser(1));
    }
}
