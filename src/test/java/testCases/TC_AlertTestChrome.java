package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_AlertTestChrome extends BaseClass {

    static String browser = "chrome";
    static String url = "http://uitestpractice.com/Students/Switchto";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testAlert1() throws InterruptedException {
        driver.findElement(By.id("alert")).click();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        String text = alert.getText();
        System.out.println(text);

        alert.accept(); // OK

        driver.findElement(By.id("confirm")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss(); // cancel

        Thread.sleep(2000);

        driver.findElement(By.id("prompt")).click();

        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Simran"); // not working in chrome

        Thread.sleep(2000);

        String str = driver.switchTo().alert().getText();
        System.out.println(str);

        driver.switchTo().alert().accept(); // clicking on OK

        Thread.sleep(2000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }


}
