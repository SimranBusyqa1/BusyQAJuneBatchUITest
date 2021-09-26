package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.List;

public class TC_CountOfActiveLinks extends BaseClass {

    static String browser = "chrome";
    static String url = "https://www.google.com/";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testLinks() throws InterruptedException {

        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println(list.size()); // count the links

        for (WebElement ele : list) {

            String link_value = ele.getAttribute("href"); // getAttribute() will fetch the value of the attribute href
            System.out.println(link_value); // printing the value of the url/links

            verifyLinks(link_value); // calling verifyLinks for each link on the webpage to check if it is active or broken
        }
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }

}
