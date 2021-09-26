package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class TC_WindowHandles extends BaseClass {

    static String browser = "chrome";
    static String url = "http://demo.automationtesting.in/Windows.html";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testWindowHandles() throws InterruptedException {
        String parent_tab_id = driver.getWindowHandle(); // get the single value of the current tab
        System.out.println(parent_tab_id);

        driver.findElement(By.xpath("//button[contains(text(),'click')]")).click();

        // Set<String> tabs = driver.getWindowHandles(); // Set will not maintain insertion order
        // ArrayList maintains insertion order

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // set to arraylist
        // Set<String> tabs = driver.getWindowHandles();
        driver.switchTo().window(tabs.get(1)); // switching to the child tab
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(parent_tab_id);
        // driver.switchTo().window(tabs.get(0));
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
