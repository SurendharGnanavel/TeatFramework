/**
 * 
 */
package commonActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author sureng
 *
 */
public class UIActionsImp implements UIActions {

	public WebElement ele;
	public ExtentReports report;
	public ExtentTest test;
	
	public WebElement getLocator(WebDriver driver,String locator) {
		By temp = null;
		try {
			String[] locatorType = locator.split(Constants.DELIMITER);
			switch (locatorType[1].toLowerCase()) {
			case Constants.ID:
				temp = By.id(locatorType[2]);
				break;
			case Constants.XPATH:
				temp = By.xpath(locatorType[2]);
				break;
			case Constants.CSSSELECTOR:
				temp = By.cssSelector(locatorType[2]);
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
		return driver.findElement(temp);
	}

	public void click(WebDriver driver,String locator)  {
		try {	
			ele = getLocator(driver,locator);
			ele.click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}

	public void sendKeys(WebDriver driver,String locator, String value) {
		try {
			ele = getLocator(driver,locator);
			ele.sendKeys(value);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}

	public void wait(WebDriver driver,String locator, long timeout) {
		try {
			Wait w = new WebDriverWait(driver,timeout);
			ele = getLocator(driver,locator);
			w.until(ExpectedConditions.elementToBeClickable(ele));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}

	public String Screenshot(WebDriver driver,String fileName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			Date date = new Date();
			Timestamp ts1= new Timestamp(date.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fileName1  = fileName+Constants.screenshot+"\\"+sdf.format(ts1).replace("-","_").replace(":", "_").replace(" ", "_");
			FileUtils.copyFile(src, new File(fileName1));
			return fileName1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
		return null;
	}

	public void propertyLoad(String filePath) {
		try {
			FileReader  fr = new FileReader(new File(filePath));
			Properties prop =new Properties();
			prop.load(fr);
			FileInputStream fis = new FileInputStream(new File(filePath));
			prop.load(fis);
		}catch(Exception e ) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

	}

	public WebDriver driverInitilization(WebDriver driver,String browser) {
		try {
			switch(browser.toUpperCase()) {
			case Constants.CHROME: 
				WebDriverManager.chromedriver().setup(); 
				driver = new ChromeDriver();
				break;
			case Constants.IE: 
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			default:
				driver = new ChromeDriver();
				break;
			}
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
		return driver;
	}
	
	public void clickByAction(WebDriver driver,String locator) {
		try {
			Actions a = new Actions(driver);
			a.moveToElement(getLocator(driver,locator)).build().perform();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String createResultFolder(String parentLocation) {
		try {
			Date date = new Date();
			Timestamp ts= new Timestamp(date.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fileName  = Constants.results+"\\Temp_"+sdf.format(ts).replace("-","_").replace(":", "_").replace(" ", "_");
			String screenshot  = fileName+Constants.screenshot;
			File  temp = new File(screenshot);
			if(!temp.exists()) {
				temp.mkdirs();
				
			}
			return fileName;
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
		return null;
	}
	public ExtentReports ExtentReport(String ResutlLocation) {
		try {
			return new ExtentReports(ResutlLocation+Constants.fileSep+"ExtentReportResults.html");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	public ExtentTest ExtentTest(ExtentReports report,String testName) {
		try {
			return report.startTest(testName);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

}
