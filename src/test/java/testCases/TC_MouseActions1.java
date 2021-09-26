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

public class TC_MouseActions1 extends BaseClass {

    static String browser = "chrome";
    static String url = "http://uitestpractice.com/Students/Actions";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testMouseActions1() throws InterruptedException {

        Actions action = new Actions(driver);

        // hover
        WebElement hover_ele = driver.findElement(By.id("div2"));

        action.moveToElement(hover_ele).perform(); // perform() is compulsory for single method/ mouse action
        Thread.sleep(2000);

        // double click

        WebElement dbl = driver.findElement(By.name("dblClick"));
        action.doubleClick(dbl).perform();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // right click
        WebElement rt_click = driver.findElement(By.name("click"));
       // action.contextClick(rt_click).perform();
         Thread.sleep(2000);

        // drag and drop 1

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        //action.dragAndDrop(drag, drop).perform();
        Thread.sleep(2000);

        // drag and drop 2
       action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform(); // build().perform() for multiple methods / mouse actions
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
