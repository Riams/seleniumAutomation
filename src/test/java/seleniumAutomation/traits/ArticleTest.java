package seleniumAutomation.traits;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ArticleTest extends BaseTest
{
	//Please review my appium automation scripts first. due to time constraints i have not done much in selenium Automation.
	
	   @Test
	   public void login() 
	   {
	     System.out.println("Login");
	    
	     
	     driver.findElement(By.cssSelector(".nav-login>a")).click();
	     driver.findElement(By.id("j_username")).sendKeys("digitaltest10");
	     driver.findElement(By.id("j_password")).sendKeys("Sphdigital1");
	     driver.findElement(By.cssSelector("[type='submit']")).click();
	     boolean logoutPresent=isElementPresent("cssSelector",".nav-logout"); 
	     Assert.assertTrue(logoutPresent, "Failed to logout");
	   
	   }
	   
	   @Test
	   public void verifyArticle()
	   {
		  String article_Title=driver.findElement(By.cssSelector(".block-link")).getAttribute("title").trim();
		  
		  
		  driver.findElement(By.cssSelector(".block-link")).click();
		  String strHeadline=driver.findElement(By.cssSelector(".headline.node-title")).getText().trim();
		  Assert.assertEquals(article_Title, strHeadline,"Mismatch is article tittle and header");
		 
		  String imageSource=driver.findElement(By.cssSelector(".img-responsive")).getAttribute("src");
		  boolean isBrokernArticleImagedisplayed=verifyImageisBroken(imageSource);
		  
		  Assert.assertTrue(isBrokernArticleImagedisplayed,"Brokern Article image found");
	   }
	   
	   @Test
	   public void logout() 
	   {
		   clickElement("cssSelector",".nav-logout");
	   }
	   
	   
	   
}
