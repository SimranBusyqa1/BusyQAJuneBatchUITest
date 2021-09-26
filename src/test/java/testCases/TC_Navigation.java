package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_Navigation extends BaseClass {

    static String browser = "chrome";
    static String url = "https://demo.nopcommerce.com";

    @BeforeTest
    public static void preCondition(){
        init(browser, url);
    }

    @Test
    public static void testNavigation() throws InterruptedException {

        driver.navigate().to(url);
        driver.findElement(By.className("ico-login")).click(); // redirect to login page
        Thread.sleep(2000);
        driver.navigate().back(); // go back to homepage
        Thread.sleep(2000);
        driver.navigate().forward(); // go forward to login page
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
