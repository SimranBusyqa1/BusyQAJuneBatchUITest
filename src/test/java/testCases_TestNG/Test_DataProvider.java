package testCases_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_DataProvider {

    @Test(dataProvider = "data")
    public void loginTest(String username, String password){

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.manage().window().maximize();

        WebElement user = driver.findElement(By.id("txtUsername"));
        WebElement pass = driver.findElement(By.id("txtPassword"));
        WebElement btn = driver.findElement(By.id("btnLogin"));

        user.sendKeys(username);
        pass.sendKeys(password);
        btn.click();

        driver.close();

    }

    @DataProvider(name = "data")
    public Object[][] loginData(){

        Object[][] login = { {"admin", "admin"}, {"admin", "admin1"}, {"Admin", "admin123"} };
        return login;
    }
}
