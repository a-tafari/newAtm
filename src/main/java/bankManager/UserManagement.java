package bankManager;

import java.util.ArrayList;

/**
 * Created by abijah on 10/6/16.
 */
public class UserManagement {
    private ArrayList<UserInfo> userList;

    public UserManagement(){
        this.userList = new ArrayList<UserInfo>();
    }

    public void addUser(String name, int pin){
        userList.add(new UserInfo(name, pin));
    }

    public UserInfo getUser(int currentUserID){
        for (UserInfo user: userList){
            if (user.getUserID() == currentUserID){
                return user;
            }
        }
        return null;
    }


}
