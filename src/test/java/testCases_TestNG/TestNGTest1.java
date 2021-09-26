package testCases_TestNG;

import org.testng.annotations.*;

public class TestNGTest1 {

   @BeforeSuite
   public void setupForALlTests(){

       System.out.println("Before Suite, setup for all the tests");
   }
   @AfterSuite
   public void cleanUp(){
       System.out.println("After Suite");
   }

   @BeforeTest
   public void testSetup(){
       System.out.println("Before Test");
   }

   @AfterTest
   public void testEnd(){
       System.out.println("After Test");
   }

   @BeforeClass
   public void beforeClassTest(){
       System.out.println("Before Class1");
   }
   @AfterClass
   public void afterClassTest(){
       System.out.println("After Class1");
   }

   @BeforeMethod
   public void beforeMethod(){
       System.out.println("Before Method");
   }
   @AfterMethod
   public void afterMethod(){
       System.out.println("After Method");
   }

    @Test
    public void test(){
        System.out.println("Test1");
    }

    @Test
    public void test1(){
        System.out.println("Test2");
    }
}


