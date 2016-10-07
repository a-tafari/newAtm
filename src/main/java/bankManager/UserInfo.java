package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class UserInfo {
    private int userID;
    private static int idCounter = 1;
    private String userName;

    private int pin;

    public UserInfo(String name, int pin){
        this.userName = name;
        this.pin = pin;
        this.userID = idCounter++;
    }

    public void setName(String name){
        this.userName = name;
    }

    public String getName(){
        return userName;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public int getPin(){
        return pin;
    }

    public int getUserID(){
        return userID;
    }

}
