package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.LinkedList;
import java.util.List;

public class TC_JSExec1 extends BaseClass {


    static String browser = "chrome";
    static String url = "http://uitestpractice.com/Students/Switchto";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testDropDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver; //typecasting

        // Opening new blank tab

        js.executeScript("window.open()"); // opening a new blank tab in the browser
        LinkedList<String> tabs = new LinkedList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // new child tab/blank tab
        driver.switchTo().window(tabs.get(0)); // parent tab
        Thread.sleep(3000);

        // Clicking on an element
        //WebElement button = driver.findElement(By.id(""));
        //js.executeScript("arguments[0].click();", button); // element to be clicked
    }

    @AfterTest
    public void postCondition(){

        quitBrowser();
    }
}
