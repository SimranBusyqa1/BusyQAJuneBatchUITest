package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.Set;

public class TC_Cookies extends BaseClass {

    static String browser = "chrome";
    static String url = "http://demo.guru99.com/test/cookie/selenium_aut.php";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testCookies() throws InterruptedException {

        driver.findElement(By.name("username")).sendKeys("abc123");
        driver.findElement(By.name("password")).sendKeys("123xyz");
        driver.findElement(By.name("submit")).click(); // log in to the website
        Thread.sleep(3000);

        // Capturing all the cookies used by the current server
        Set<Cookie> allCookies = driver.manage().getCookies();

        System.out.println("Initial cookies size: " + allCookies.size());

        for(Cookie ck : allCookies)
        {
            System.out.println("Cookie: " + ck);
        }

        Cookie login = driver.manage().getCookieNamed("Selenium"); // get specific cookie by the name
        System.out.println("Selenium cookie: " + login);

        Cookie usercookie = new Cookie("mycookie", "test"); // user defined cookie
        driver.manage().addCookie(usercookie);

        System.out.println("New user cookie: " + driver.manage().getCookieNamed("mycookie"));

        allCookies = driver.manage().getCookies();
        System.out.println("After Cookies size: " + allCookies.size()); // incremented by 1

        driver.close(); // close the first driver instance


        //open second driver instance
        init(browser, url);

        for(Cookie cookie : allCookies) {  // add old session to this new driver instance so that old login should work + new session cookies
            driver.manage().addCookie(cookie); // adding the cookies to the current browser instance one at a time
        }

        Thread.sleep(3000);
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");  // reload it; after adding cookies refresh the browser to take effect

        driver.navigate().refresh(); // hard refresh is required sometimes if previous reload hasn't worked (workaround/optional if no error previously)


        Set<Cookie> newCookies = driver.manage().getCookies(); // second driver instance cookies (new + old)
        System.out.println("New cookies size: " + newCookies.size());
        for(Cookie ck : newCookies)
        {
            System.out.println("New Cookie: " + ck);
        }


        driver.manage().deleteCookie(usercookie);
        newCookies = driver.manage().getCookies(); // updating the list of newCookies variable
        System.out.println("Size after deleting user cookie: " + newCookies.size()); // reduced by 1

        driver.manage().deleteCookieNamed("Selenium");
        newCookies = driver.manage().getCookies(); // updating the list of newCookies variable
        System.out.println("Size after deleting Selenium cookie: " + newCookies.size()); // reduced by 1

        driver.manage().deleteAllCookies();
        Thread.sleep(2000);
        newCookies = driver.manage().getCookies(); // updating the list of newCookies variable

        System.out.println("Zero cookie: " + newCookies.size()); // 0

        driver.close(); // closing second driver instance
    }
}
