package configurationProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IdentifingObject 
{
	public WebElement identifingObject(WebDriver driver,String identifier,String value)
	{
		
		WebElement dynamicLocatorElement;
		if(identifier.equalsIgnoreCase("id"))
		{
	        dynamicLocatorElement= (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
			return dynamicLocatorElement;
		}
		else if(identifier.equalsIgnoreCase("name"))
		{
			dynamicLocatorElement= (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name(value)));
			return dynamicLocatorElement;
		}
		else if(identifier.equalsIgnoreCase("xpath"))
		{
			dynamicLocatorElement= (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
			return dynamicLocatorElement;
		}
		return null;
	}
	
}
