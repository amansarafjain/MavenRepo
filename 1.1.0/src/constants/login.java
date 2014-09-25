
package com.constants;

import static com.constants.login.eventFiringWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurationProperties.ObjectLocator;

public class login  {
	public static WebDriver driver =null;
	public static WebElement ele=null;
	ObjectLocator locator=new ObjectLocator();
	 public static EventFiringWebDriver eventFiringWebDriver;
	
	public void login_application(String username,String pwd){
		/*   System.setProperty("webdriver.firefox.bin","C:\\Users\\amans.jain\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		   FirefoxProfile firefoxProfile = new FirefoxProfile();
		   driver = new FirefoxDriver(firefoxProfile);*/	
	
		
		   if(locator.getBrowser().equalsIgnoreCase("firefox")||locator.getBrowser().equalsIgnoreCase("mozilla"))
			   
		   	   {
				   driver = new FirefoxDriver();
			   }
		   
		   else if(locator.getBrowser().equalsIgnoreCase("ie")||locator.getBrowser().equalsIgnoreCase("internet explorer")||locator.getBrowser().equalsIgnoreCase("explorer"))
			   
	   	   {
			   driver = new InternetExplorerDriver();
		   }

		   else if(locator.getBrowser().equalsIgnoreCase("chrome"))
			   
	   	   {
			   System.setProperty("webdriver.chrome.driver", "/usr//bin/chromedriver");
			   driver = new ChromeDriver();
		   }
		   
			eventFiringWebDriver = new EventFiringWebDriver(driver);
	        eventFiringWebDriver.register(new WebDriverEventListenerDemo());   
		   
		   eventFiringWebDriver.manage().window().maximize();
		   eventFiringWebDriver.get(locator.getEnvironment());
		   WebElement myDynamicElement = null;
	       myDynamicElement = (new WebDriverWait(eventFiringWebDriver, 200)).until(ExpectedConditions.presenceOfElementLocated(By.id("userid")));
	       eventFiringWebDriver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	       eventFiringWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	       eventFiringWebDriver.findElement(By.xpath("//input[@name='userid']")).sendKeys(username+"@"+locator.getTenant()+".com");
		   eventFiringWebDriver.findElement(By.id("password")).sendKeys(pwd);
		   eventFiringWebDriver.findElement(By.id("xsubmit")).click();
	}
}
