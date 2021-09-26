package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

import java.util.LinkedList;

public class TC_WebTable extends BaseClass {

    static String browser = "chrome";
    static String url = "https://opensource-demo.orangehrmlive.com/";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testWebTable() throws InterruptedException {

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        int column_size = driver.findElements(By.xpath("//table[@id='resultTable']/thead/tr/th")).size(); // 5

        int row_size = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size(); // 45


        for(int i=1; i<=row_size; i++) { // rows till 50
            LinkedList<String> employee_info = new LinkedList<String>(); // flushing the old values
            for (int j=2; j<=column_size; j++) { // columns till 5

                String value = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                employee_info.add(value); // single value is getting added

            }
            System.out.println(employee_info); // printing values from each row
        }
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
