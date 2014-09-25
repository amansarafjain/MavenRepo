package configurationProperties;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class ObjectLocator
{
	IdentifingObject config=new IdentifingObject();
	String [] key;
	WebElement obj1;
	Properties prop;
	String url="";
	String tenant="";
	String env="";
	String Browser="";
	String driverforbrowser="";
	String Driverpath="";
	public ObjectLocator() 
	{
		try
		{
			prop=new Properties();
			FileInputStream Fi=new FileInputStream("src/configurationProperties/Configuration.properties");
			prop.load(Fi);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
public WebElement objectReader(WebDriver driver,String xyz)
{
	key=prop.getProperty(xyz,"").split(",");
	obj1= config.identifingObject(driver,key[0],key[1]);
	return obj1;
}
public String getURL() 
{
	url=prop.getProperty("URL");
	return url;	
}
public String getBrowser()
{
	Browser=prop.getProperty("browser");
	return Browser;
}
public String getdriverforbrowser()
{
	driverforbrowser=prop.getProperty("driverforbrowser");
	return driverforbrowser;	
}
public String getpathToDriver()
{
	Driverpath=prop.getProperty("Driverpath");
	return Driverpath;	
}


public String getTenant() 
{ 
		tenant=prop.getProperty("TENANT");

		if(tenant.equals("dell")||(tenant.equals("nexmech")))
	{
			return tenant;
	}

		else {
			 throw new WebDriverException("Please provide valid TENANT name");
		}
}


public String getEnvironment() 
{
		env=prop.getProperty("ENVIRONMENT");
		
		if (env.equalsIgnoreCase("qa3"))
			{
				url="https://qa3.ssi-cloud.com";
					}
		else if (env.equalsIgnoreCase("qadev"))
		{
			url="https://qa.dev.ssi-cloud.com";
			}
		
		else if (env.equalsIgnoreCase("sfdcint01"))
		{
			url="https://sfdcint01.ssi-cloud.com/";
		}
		else if (env.equalsIgnoreCase("stg"))
		{
			url="https://stgnext.ssi-cloud.com/";
			}
		else if (env.equalsIgnoreCase("ise1"))
		{
			url="https://ise1.ssi-cloud.com";
				}
		else if (env.equalsIgnoreCase("qadevint"))
		{
			url="https://qa-internal.dev.ssi-cloud.com";
				}
		else if (env.equalsIgnoreCase("dellstg"))
		{
			url="https://dellstgnext.ssi-cloud.com";
		}
		else if (env.equalsIgnoreCase(""))
		{
			url="https://qa3.ssi-cloud.com";
		}
		else {
     			throw new WebDriverException("Please Provide Valid Environment");
		}
	return url;
}
}
