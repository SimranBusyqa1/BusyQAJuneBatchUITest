package testCases_TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_Parameter {


    @Parameters({"browser", "user", "pass"})
    @Test
    public void test(String abc, String user, String pass){

        System.out.println("Test is: " + abc);
        System.out.println("User is: " + user);
        System.out.println("Password is: " + pass);
    }
}
