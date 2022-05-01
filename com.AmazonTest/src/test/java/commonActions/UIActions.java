/**
 * 
 */
package commonActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author sureng
 *
 */
public interface UIActions {
	
	
	/**
	 * This Method will initialize the webdriver with respect to the String browser
	 * @param browser - represents a type of Browser
	 */
	public WebDriver driverInitilization(String browser) ;
	
	
	/**
	 * This Method will return the webElement with respect to the locator.
	 * @param locator - is String parameter and the format for locator is locatorType|Property ("|" is a delimiter)
	 * @return
	 */
	public WebElement getLocator(String locator);
	
	/**
	 * This Method will do the Web UI click operation with respect to the locator.
	 * @param locator is String parameter and the format for locator is locatorType|Property ("|" is a delimiter)
	 * @return
	 */
	public void click(String locator);
	
	
	/**
	 * This Method will help user to enter the text into Web UI with respect to the locator.
	 * @param locator is String parameter and the format for locator is locatorType|Property ("|" is a delimiter)
	 * @param value value which needs to be entered into the UI
	 * @return
	 */
	public void sendKeys(String locator,String value);
	
	/**
	 * This Method helps to wait the script until the certain conditions satisfies or until the timeout.
	 * @param locator locator is String parameter and the format for locator is locatorType|Property ("|" is a delimiter)
	 * @param timeout - this is Maximum time up to which script can wait for the element to load
	 * @return
	 */
	public void wait(String locator,long timeout);
	
	/**
	 * this Method will help us to take the screenshot and save the screen prints to the provided location 
	 * @param fileName - location to save the screen print 
	 * @return
	 */
	public void Screenshot(String fileName);
	
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
	public void clickByAction(String locator);
	

}
