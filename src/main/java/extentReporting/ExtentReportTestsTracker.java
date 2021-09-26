package extentReporting;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportTestsTracker {
	static ExtentReports extent = ExtentReportDefinition.getInstance();
	public static ExtentTest test;

	public static ExtentTest startTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	public static ExtentTest getStatus() {

		return test;
	}

	public static void finishTest() {
		extent.flush();
	}
}
