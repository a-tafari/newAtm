package bankManager;

import java.util.Scanner;

/**
 * Created by abijah on 10/6/16.
 */
public class UserInput {
    public Scanner scan = new Scanner(System.in);

    public int getUserInt(){
        return scan.nextInt();
    }

    public double getUserDouble(){
        return scan.nextDouble();
    }

    public String getUserString(){
        return scan.next().toString();
    }
}
