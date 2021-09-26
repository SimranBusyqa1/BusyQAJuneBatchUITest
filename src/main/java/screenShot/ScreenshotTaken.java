package screenShot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotTaken {

    String dest = "";

    public void getScreenShot(WebDriver driver, String scenario_name){

        try {

            TakesScreenshot ts=(TakesScreenshot)driver; // narrow type conversion or Down casting
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Generic code to create system date format
            SimpleDateFormat s=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
            String d = s.format(new Date());

            dest = System.getProperty("user.dir")+"\\Resources\\ScreenShots\\/"+d+"-"+scenario_name+".png";
            File destination = new File(dest);

            FileHandler.copy(source, destination); // actually saving the file to the desired destination
        }

        catch (Exception e) {
            Reporter.log(e.getMessage(),true);
        }
    }
}
