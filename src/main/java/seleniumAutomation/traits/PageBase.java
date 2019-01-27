package seleniumAutomation.traits;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

public class PageBase<HttpResponse> 
{
	 static WebDriver driver=null;
	 
	 protected void clickElement(String locatorType, String locator)
		{
			// here we can use Java reflection to identify the element instead of putting switch case
			switch (locatorType) 
			{
			case "id":
				driver.findElement(By.id(locator)).click();
				break;
			case "xpath":
				driver.findElement(By.xpath(locator)).click();
				break;

			}
			
		}
		
		
		protected void enterValue(String locatorType, String locator,String value)
		{
			// here we can use Java reflection to identify the element instead of putting switch case
			switch (locatorType) 
			{
			case "id":
				driver.findElement(By.id(locator)).sendKeys(value);
				break;
			case "xpath":
				driver.findElement(By.xpath(locator)).sendKeys(value);
				break;

			}
			
		}
		
		protected void clickElementifExist(String locatorType, String locator)
		{
			try
			{
			// here we can use Java reflection to identify the element instead of putting switch case
			switch (locatorType) 
			{
			case "id":
				driver.findElement(By.id(locator)).click();
				break;
			case "xpath":
				driver.findElement(By.xpath(locator)).click();
				break;

			}
			}
			catch(Exception ex)
			{
				
			}
			
		}
		

		protected void singleTapElement(String locatorType, String locator)
		{
			// here we can use Java reflection to identify the element instead of putting switch case
			WebElement element = null;
			switch (locatorType) 
			{
			case "id":
				element=driver.findElement(By.id(locator));
				break;
			case "xpath":
				element=driver.findElement(By.xpath(locator));
				break;

			}
			TouchActions action =new TouchActions(driver);
			action.singleTap(element);
			action.perform();
			
			
		}
		
		
		protected static boolean isElementPresent(String locatorType,String locator)
		{
	       
	        try{
	             // here we can use Java reflection to identify the element instead of putting switch case
	     		switch (locatorType) 
	     		{
	     		case "id":
	     			driver.findElement(By.id(locator));
	     			break;
	     		case "xpath":
	     			driver.findElement(By.xpath(locator));
	     			break;
	     			
	     		case "cssSelector":
	     			driver.findElement(By.cssSelector(locator));
	     			break;

	     		}
	     		  return true;
	        }
	        catch (Exception e)
	        {
	        	return false;
	        }

	}
		
		
		protected String getText(String locatorType,String locator)
		{
			try{
	            // here we can use Java reflection to identify the element instead of putting switch case
				WebElement element=null;
	    		switch (locatorType) 
	    		{
	    		case "id":
	    			element=driver.findElement(By.id(locator));
	    			break;
	    		case "xpath":
	    			element=driver.findElement(By.xpath(locator));
	    			break;

	    		}
	    		  return element.getText();
	       }
			catch(Exception ex)
			{
				
			}
			return null;
		}
		
		public boolean verifyImageisBroken(String imageSource)
		{
			
			try {
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(imageSource);
				org.apache.http.HttpResponse response = client.execute(request);
				// verifying response code he HttpStatus should be 200 if not,
				// increment as invalid images count
				if (response.getStatusLine().getStatusCode() != 200)
				{
					return false;
				}
					
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return true;
		}
		
		
		

}
