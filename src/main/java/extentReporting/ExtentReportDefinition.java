package extentReporting;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDefinition {
    private static ExtentReports extent; // has not been instantiated yet
    private static String reportFileName = "Test-Automaton-Report"+".html";
    private static String reportFilepath = System.getProperty("user.dir") + "\\TestReport";
    private static String reportFileLocation =  reportFilepath +"\\"+ reportFileName;


    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = reportFileLocation;

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Set environment details
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Executed By", "Simran Raina");

        return extent;
    }
}
