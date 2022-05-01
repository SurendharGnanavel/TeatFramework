/**
 * 
 */
package commonActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sureng
 *
 */
public class UIActionsImp implements UIActions {

	public WebDriver driver;
	public WebElement ele;

	public WebElement getLocator(String locator) {
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

	public void click(String locator)  {
		try {	
			ele = getLocator(locator);
			ele.click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}

	public void sendKeys(String locator, String value) {
		try {
			ele = getLocator(locator);
			ele.sendKeys(value);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}

	public void wait(String locator, long timeout) {
		try {
			Wait w = new WebDriverWait(driver,timeout);
			ele = getLocator(locator);
			w.until(ExpectedConditions.elementToBeClickable(ele));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}

	public void Screenshot(String fileName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(fileName));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
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

}
