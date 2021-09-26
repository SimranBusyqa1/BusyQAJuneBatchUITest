package testCases_Login;

import com.codoid.products.exception.FilloException;
import excelReader.FilloUtility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screenShot.ScreenshotTaken;
import testBase.BaseClass;

import java.util.ArrayList;

@Listeners(listeners.TestListener.class)
public class TC_Login extends BaseClass {

    static String browser = "chrome";
    static String url = "https://opensource-demo.orangehrmlive.com/";
    static ArrayList<String> loginValues = new ArrayList<>();
    FilloUtility fu;
    String filepath=System.getProperty("user.dir") + "\\Resources\\DataManager\\";
    String excelName = "loginData.xlsx";
    String Username;
    String Password;
    String expectedErrorMessage ="Invalid credentials";
    ScreenshotTaken st;

    @BeforeTest
    public void preCondition(){

        init(browser, url);
    }

    @Test
    public void testTC_Login_01_Negative() throws FilloException {

        fu = new FilloUtility();
        loginValues = fu.getData(filepath, excelName, "login", 1, "TestNumber");
        Username = loginValues.get(0);
        Password = loginValues.get(1);
        System.out.println(Username);
        System.out.println(Password);
        driver.findElement(By.id("txtUsername")).sendKeys(Username);
        driver.findElement(By.id("txtPassword")).sendKeys(Password);
        driver.findElement(By.id("btnLogin")).click();
        st = new ScreenshotTaken();
        st.getScreenShot(driver, "TC_Login_01_Negative");
        String errorMsg = driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
       fu.updateData(filepath, "loginData.xlsx", "login", 1, "result",  errorMsg);
        Assert.assertEquals(errorMsg, expectedErrorMessage);
    }

    @Test
    public void testTC_Login_02_Negative() throws FilloException {

        fu = new FilloUtility();
        loginValues = fu.getData(filepath, excelName, "login", 2, "TestNumber");
        Username = loginValues.get(0);
        Password = loginValues.get(1);
        System.out.println(Username);
        System.out.println(Password);
        driver.findElement(By.id("txtUsername")).sendKeys(Username);
        driver.findElement(By.id("txtPassword")).sendKeys(Password);
        driver.findElement(By.id("btnLogin")).click();
        st = new ScreenshotTaken();
        st.getScreenShot(driver, "TC_Login_02_Negative");
        String errorMsg = driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
        fu.updateData(filepath, "loginData.xlsx", "login", 2, "result",  errorMsg);
        Assert.assertEquals(errorMsg, expectedErrorMessage);
    }
    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
