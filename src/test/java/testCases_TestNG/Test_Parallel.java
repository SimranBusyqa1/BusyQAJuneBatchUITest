package testCases_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_Parallel {

    WebDriver driver;

    @Parameters("browser")
    @Test
    public void browserTest(String browse) {

        if(browse.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\chromedriver.exe\\");
            driver = new ChromeDriver();
        }

        else if(browse.equalsIgnoreCase("Firefox")) {

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\geckodriver.exe\\");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/Students/Switchto");
        driver.close();

    }
}
