/**
 * 
 */
package amazonTest;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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
	 
	
	@Test
	public void testSetup() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir")+Constants.PROPLocation));
			driver = uiActions.driverInitilization(prop.getProperty("Browser"));
			driver.get(prop.getProperty("ApplicationURL"));
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.toString());
		}
		
		
	}

}
