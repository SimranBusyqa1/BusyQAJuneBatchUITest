package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class BaseClass {

    public static WebDriver driver;

    public static void init(String browser, String url){ // TC will be passing browser and url values

        if(browser.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver(); // create instance of chromeDriver and assign to WebDriver ref. variable

        }

        else if(browser.equalsIgnoreCase("firefox")){

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Resources\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver(); // create instance of chromeDriver and assign to WebDriver ref. variable

        }

       driver.get(url); // open this url
       driver.manage().window().maximize(); // maximizing the window

    }


    public static void closeBrowser(){

        driver.close();

    }

    public static void quitBrowser(){

        driver.quit();

    }

    public static void verifyLinks(String link) {

        try
        {
            URL url1 = new URL(link);

            URLConnection url2 = url1.openConnection();

            HttpURLConnection httpURLConnect=(HttpURLConnection)url2; // create connection -> type casting from variable of one class type to another class type

            httpURLConnect.setConnectTimeout(3000); // wait for the response - 3 seconds

            httpURLConnect.connect(); // triggering/hitting the links in the backend

            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_OK) // active link condition
            {
                System.out.println(link+": "+httpURLConnect.getResponseMessage()); // message is success

            }
            else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  // only checking for 404 for broken links
            {
                System.out.println(link+": "+httpURLConnect.getResponseMessage() + " : "+ HttpURLConnection.HTTP_NOT_FOUND);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
