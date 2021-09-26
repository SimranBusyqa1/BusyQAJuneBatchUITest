package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testBase.BaseClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(listeners.TestListener.class)
public class TC_Get_Close_Quit_Conditional extends BaseClass {


    static String browser = "Chrome";
    static String url1 = "https://demo.nopcommerce.com";
    static String url2 = "http://demo.automationtesting.in/Windows.html";

    @BeforeTest
    public static void preCondition(){

        init(browser, url1);
        // init(browser, url2);

    }

    @Test
    public static void getCommands() throws InterruptedException { // Test Method

        String title = driver.getTitle();
        System.out.println(title);

            assertEquals(title, "nopCommerce demo store");

        driver.findElement(By.className("ico-register")).click();
        Thread.sleep(2000);

        String url = driver.getCurrentUrl(); // get the url
        System.out.println("Current URL is: " + url);

        // Condition methods

        Boolean disp = driver.findElement(By.id("FirstName")).isDisplayed();
        System.out.println(disp);

        Boolean enable = driver.findElement(By.name("register-button")).isEnabled();
        System.out.println(enable);

        WebElement gender = driver.findElement(By.cssSelector("input[value=M]"));
        Boolean select = gender.isSelected();

        System.out.println("Checkbox is selected: " + select);

        if(select == false){

            gender.click();
            select = gender.isSelected();
            System.out.println("Checkbox is selected: " + select);
            assertTrue(select);

        }
    }

    @Test(enabled=false)
    public static void closeAndQuit() throws InterruptedException {

        driver.findElement(By.xpath("//button[contains(text(), ' click ')]")).click();
        Thread.sleep(2000);
        // driver.close(); // will close first tab
        driver.quit(); // will close both the tabs
    }

    @AfterTest
    public static void postCondition(){

        closeBrowser();

    }

}
