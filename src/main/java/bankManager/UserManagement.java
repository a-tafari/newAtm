package bankManager;

/**
 * Created by abijah on 10/6/16.
 */
public class UserManagement {
    private ArrayList<Customer> customerList;

    public CustomerManager(){
        this.customerList = new ArrayList<Customer>();
    }

    public void addCustomer(String name, int pin){
        customerList.add(new Customer(name, pin));
    }

    public Customer getCustomer(int currentUserID){
        for (Customer customer: customerList){
            if (customer.getCustomerID() == currentUserID){
                return customer;
            }
        }
        return null;
    }

}
