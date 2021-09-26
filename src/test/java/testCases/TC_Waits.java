package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.concurrent.TimeUnit;

public class TC_Waits extends BaseClass {

    static String browser = "chrome";
    static String url = "https://demo.nopcommerce.com";
    static String url1 = System.getProperty("user.dir") + "\\Resources\\index.html";

    @BeforeTest
    public static void preCondition(){

        init(browser, url1);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public static void testExplicitWait() throws InterruptedException {


        driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

        By by = By.xpath("//p[text()='TestNG']");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        String var = driver.findElement(by).getText(); // this will extract the text of the element
        System.out.println(var);

    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }

}
