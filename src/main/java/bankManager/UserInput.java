package bankManager;

import java.util.Scanner;

/**
 * Created by abijah on 10/6/16.
 */
public class UserInput {
    public Scanner sc = new Scanner(System.in);

    public int getUserInt(){
        return sc.nextInt();
    }

    public double getUserDouble(){
        return sc.nextDouble();
    }

    public String getUserString(){
        return sc.next().toString();
    }
}
