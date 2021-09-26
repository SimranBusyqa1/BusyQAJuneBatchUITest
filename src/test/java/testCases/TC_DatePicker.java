package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.List;

public class TC_DatePicker extends BaseClass {

    static String browser = "chrome";
    static String url = "https://www.redbus.in/";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testDatePicker() throws InterruptedException {
        driver.findElement(By.id("onward_cal")).click();

        String desired_month = "Nov 2022";
        String desired_date = "2";



        while (true) {

            String actual_month = driver.findElement(By.xpath("//tr[@class='rb-monthHeader']/td[2]")).getText();
            if (actual_month.equals(desired_month)) {
                System.out.println(actual_month);
                break;

            } else {
                System.out.println(actual_month);
                driver.findElement(By.xpath("//tr[@class='rb-monthHeader']/td[3]")).click(); // next month
            }
        }

        int column_size = 7; // as per the days (Mon - Sun)
        int flag = 0;
        int row_size = driver.findElements(By.xpath("//table/tbody/tr")).size(); // 8

        for(int i = 3; i<=row_size; i++){ // row

            for(int j = 1; j<= column_size; j++){ // column

                String actual_date = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).getText();

                if(actual_date.equals(desired_date)){
                    driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).click();
                    flag = 1; // set flag = 1
                    System.out.println(actual_date);
                    Thread.sleep(3000);
                    break; // breaking out of inner loop
                }
                else{
                    continue;
                }
            }
            if(flag == 1){ // selection of the date is done
                break;
            }
        }
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}

