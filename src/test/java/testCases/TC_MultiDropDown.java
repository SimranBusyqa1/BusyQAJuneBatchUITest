package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.List;

public class TC_MultiDropDown extends BaseClass {

    static String browser = "chrome";
    static String url = "http://uitestpractice.com/Students/Select";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testMultiDropDown() throws InterruptedException {

        WebElement countries =  driver.findElement(By.id("countriesMultiple"));

        Select select_countries = new Select(countries);

        // selection multiple
        select_countries.selectByIndex(0);
        Thread.sleep(2000);
        select_countries.selectByValue("china");
        Thread.sleep(2000);
        select_countries.selectByVisibleText("England");
        Thread.sleep(2000);

        // deselection
        select_countries.deselectByValue("china");
        Thread.sleep(2000);
        select_countries.deselectAll();
        Thread.sleep(2000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
