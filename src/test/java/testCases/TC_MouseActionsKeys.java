package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.List;

public class TC_MouseActionsKeys extends BaseClass {

    static String browser = "chrome";
    static String url = "http://uitestpractice.com/Students/Form";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testDropDown() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement firstname = driver.findElement(By.id("firstname"));
        WebElement lastname = driver.findElement(By.id("lastname"));
        WebElement username = driver.findElement(By.id("username"));

        actions.sendKeys(firstname, "Simran").perform(); // Key Action
        actions.click(lastname).sendKeys("Raina").build().perform(); // click is a mouse action

        // Keyboard press and release
        Thread.sleep(3000);
        actions.keyDown(firstname, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); // select the whole text (CTRL+A)
        Thread.sleep(3000);
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); // copy action (CTRL+C)
        Thread.sleep(3000);
        actions.keyDown(username, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();  // paste action (CTRL+V)
        Thread.sleep(3000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
