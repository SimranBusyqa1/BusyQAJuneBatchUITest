package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.List;

public class TC_DropDown extends BaseClass {

    static String browser = "chrome";
    static String url = "https://www.globalsqa.com/demo-site/select-dropdown-menu/";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testDropDown() throws InterruptedException {

        WebElement country_list = driver.findElement(By.xpath("//select"));
        Select select_country = new Select(country_list);

        List<WebElement> list =  select_country.getOptions(); // maintaining the insertion order
        System.out.println(list.size());

       for(WebElement ele : list){
          // print all the country names on the list that we got from getOptions()
           System.out.println(ele.getText());
       }

        select_country.selectByIndex(2); // by index selecting the single option from the list

        Thread.sleep(3000);

        select_country.selectByValue("BHR");

        Thread.sleep(3000);

        select_country.selectByVisibleText("China");

        Thread.sleep(3000);

    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
