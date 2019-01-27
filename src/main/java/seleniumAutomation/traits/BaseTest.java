package seleniumAutomation.traits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Hello world!
 *
 */
public class BaseTest extends PageBase
{
  
   
   @BeforeSuite
   public void setUp()
   {
	
	   System.setProperty("webdriver.gecko.driver", "H:\\gekodriver\\geckodriver.exe");
	   driver=new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.get("https://www.straitstimes.com");
	   
   
   }
   
   @AfterSuite
   public void tearDown()
   {
	  driver.quit();
   }
   
   
}
