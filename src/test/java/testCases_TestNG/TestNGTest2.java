package testCases_TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGTest2 {

    @BeforeClass
    public void beforeClassTest1(){
        System.out.println("Before Class2");
    }
    @AfterClass
    public void afterClassTest1(){
        System.out.println("After Class2");
    }
    @Test
    public void test2(){
        System.out.println("Test3");
    }
}
