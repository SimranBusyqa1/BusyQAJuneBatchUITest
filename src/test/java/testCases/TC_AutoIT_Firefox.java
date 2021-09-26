package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.io.IOException;

public class TC_AutoIT_Firefox extends BaseClass {

    static String browser = "firefox";
    static String url = "http://uitestpractice.com/Students/Widgets";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testAutoIT() throws IOException, InterruptedException {

        WebElement ele = driver.findElement(By.id("image_file"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", ele);

        // window file explorer GUI handling using AutoIT
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\Resources\\fileupload_Firefox.exe");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Upload']")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }


}
