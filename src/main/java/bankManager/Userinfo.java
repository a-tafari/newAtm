package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class Userinfo {
    private int customerID;
    private static int customerIDCounter = 1;
    private String name;
    private int pin;

    public Customer(String name, int pin){
        this.name = name;
        this.pin = pin;
        this.customerID = customerIDCounter++;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public int getPin(){
        return pin;
    }

    public int getCustomerID(){
        return customerID;
    }

}
