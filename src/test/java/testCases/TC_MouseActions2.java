package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.List;

public class TC_MouseActions2 extends BaseClass {

    static String browser = "chrome";
    static String url = "https://jqueryui.com/slider/";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testMouseActionsSlider() throws InterruptedException {

        WebElement frame1 = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame1);

        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));

        Actions action = new Actions(driver);

        action.dragAndDropBy(slider, 500, 0).perform();
        Thread.sleep(4000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
