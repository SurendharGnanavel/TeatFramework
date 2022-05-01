/**
 * 
 */
package amazonTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mongodb.diagnostics.logging.Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonActions.Constants;
import commonActions.UIActions;
import commonActions.UIActionsImp;

/**
 * @author sureng
 *
 */
public class MyTest {
	
	 public UIActions uiActions = new UIActionsImp(); 
	 public WebDriver driver;
	 public String resultFolder;
	 public ExtentReports report;
	 public ExtentTest test;
	 
	
	@BeforeClass
	public void testSetup() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(Constants.PROPLocation));
			resultFolder =uiActions.createResultFolder(Constants.results);
			report = uiActions.ExtentReport(resultFolder);
			test = uiActions.ExtentTest(report, "AmazonTest");
			driver = uiActions.driverInitilization(driver,prop.getProperty("Browser"));
			driver.get(prop.getProperty("ApplicationURL"));
			test.log(LogStatus.INFO, "Driver launched and Navigated to "+prop.getProperty("ApplicationURL"));
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void HomepageActions() {
		try {
		//	uiActions.click(driver, locator);
		}catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.toString());
		}
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			String screenshotPath = uiActions.Screenshot(driver,resultFolder);
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
	}

}
