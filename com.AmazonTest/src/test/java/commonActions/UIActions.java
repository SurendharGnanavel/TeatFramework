/**
 * 
 */
package commonActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author sureng
 *
 */
public interface UIActions {
	
	
	/**
	 * This Method will initialize the webdriver with respect to the String browser
	 * @param browser - represents a type of Browser
	 */
	public WebDriver driverInitilization(WebDriver driver,String browser) ;
	
	
	/**
	 * This Method will return the webElement with respect to the locator.
	 * @param locator - is String parameter and the format for locator is locatorType|Property ("|" is a delimiter)
	 * @return
	 */
	public WebElement getLocator(WebDriver driver,String locator);
	
	/**
	 * This Method will do the Web UI click operation with respect to the locator.
	 * @param locator is String parameter and the format for locator is locatorType|Property ("|" is a delimiter)
	 * @return
	 */
	public void click(WebDriver driver,String locator);
	
	
	/**
	 * This Method will help user to enter the text into Web UI with respect to the locator.
	 * @param locator is String parameter and the format for locator is locatorType|Property ("|" is a delimiter)
	 * @param value value which needs to be entered into the UI
	 * @return
	 */
	public void sendKeys(WebDriver driver,String locator,String value);
	
	/**
	 * This Method helps to wait the script until the certain conditions satisfies or until the timeout.
	 * @param locator locator is String parameter and the format for locator is locatorType|Property ("|" is a delimiter)
	 * @param timeout - this is Maximum time up to which script can wait for the element to load
	 * @return
	 */
	public void wait(WebDriver driver,String locator,long timeout);
	
	/**
	 * this Method will help us to take the screenshot and save the screen prints to the provided location 
	 * @param fileName - location to save the screen print 
	 * @return
	 */
	public String Screenshot(WebDriver driver,String fileName);
	
	/**
	 * THis method will load the property file 
	 * @param filePath - location of the property File
	 * @return
	 */
	public void propertyLoad(String filePath);
	
	/**
	 * This Method will perform click operation using Action class
	 * @param locator locator is String parameter and the format for locator is locatorType|Property ("|" is a delimiter)
	 */
	public void clickByAction(WebDriver driver,String locator);
	
	/**
	 * This method will create a runtime folder for the screenshot and for the extent report 
	 * @param parentLocation - location of the result folder 
	 * @return  the current result location to store the screen prints
	 */
	public String createResultFolder(String parentLocation);
	
	/**
	 * This method will create Extent report object
	 * @param ResutlLocation - Extent report location
	 * @return returns ExtentReports 
	 */
	public ExtentReports ExtentReport(String ResutlLocation);
	
	/**
	 * This Method will return the Test of extent report
	 * @param report- @see public ExtentReports ExtentReport(String ResutlLocation)
	 * @param testName - String testNanme
	 * @return
	 */
	public ExtentTest ExtentTest(ExtentReports report,String testName);

}
