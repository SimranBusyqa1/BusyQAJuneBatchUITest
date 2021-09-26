package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.List;

public class TC_AlertTestFirefox extends BaseClass {

    static String browser = "firefox";
    static String url = "http://uitestpractice.com/Students/Switchto";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testAlert2() throws InterruptedException {

        driver.findElement(By.id("prompt")).click();

        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Simran"); // sendKeys() is working

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
