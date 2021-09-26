package testCases_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Depends {

    @Test
    public void test1(){

        System.out.println("This is test 1");

    }

    @Test(dependsOnMethods = "test1")
    public void test2(){
        System.out.println("This is test 2");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = { "test1", "test2" })
    public void test3(){
        System.out.println("This is test 3");
    }
}
