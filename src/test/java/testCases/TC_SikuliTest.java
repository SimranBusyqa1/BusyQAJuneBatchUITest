package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_SikuliTest extends BaseClass {

    static String browser = "chrome";
    static String url = "http://uitestpractice.com/Students/Widgets";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testSikuli() throws FindFailed, InterruptedException {

        Screen sc = new Screen();

        Pattern choosefile = new Pattern(System.getProperty("user.dir")+"\\Resources\\choose.PNG");
        Pattern editbox = new Pattern(System.getProperty("user.dir")+"\\Resources\\editbox.PNG");
        Pattern open = new Pattern(System.getProperty("user.dir")+"\\Resources\\open.PNG");
        Pattern upload = new Pattern(System.getProperty("user.dir")+"\\Resources\\upload.PNG");

        Thread.sleep(2000);
        sc.click(choosefile);
        Thread.sleep(2000);
        sc.click(editbox); // explicitly trying to focus on the edit box by clicking
        Thread.sleep(2000);
        sc.type(editbox, System.getProperty("user.dir") + "\\Resources\\text.txt");
        Thread.sleep(2000);
        sc.click(open);
        Thread.sleep(2000);
        sc.click(upload);
        Thread.sleep(2000);
    }
}
