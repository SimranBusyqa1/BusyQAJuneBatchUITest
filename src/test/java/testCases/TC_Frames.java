package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;
public class TC_Frames extends BaseClass {

    static String browser = "chrome";
    static String url = "http://uitestpractice.com/Students/Switchto";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testFrames() throws InterruptedException {

        WebElement frame = driver.findElement(By.name("iframe_a"));
        driver.switchTo().frame(frame); // WebElement

        // driver.switchTo().frame(0); // index

        driver.findElement(By.id("name")).sendKeys("Simran");

        Thread.sleep(2000);

        driver.switchTo().defaultContent(); // bring the control/focus outside the frame back to the web page
        Thread.sleep(2000);
        driver.findElement(By.id("alert")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
