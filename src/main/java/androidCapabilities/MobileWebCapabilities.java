package androidCapabilities;


import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MobileWebCapabilities
{
   public static ResourceBundle rb;
   public static WebDriver driver;

   public void getBrowser(String Browser)
	{
    	rb=ResourceBundle.getBundle("Config");
    	
    	if(rb.getString("browserName").equalsIgnoreCase("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		this.driver=new ChromeDriver();
    	}
    	else if(rb.getString("browserName").equalsIgnoreCase("firefox"))
    	{
    		WebDriverManager.firefoxdriver().setup();
    		this.driver=new FirefoxDriver();
    	}
    	
    	else
    	{
    		WebDriverManager.chromedriver().setup();
    		this.driver=new ChromeDriver();
    	}

	}
   
   
   public void launchBrowser()
   {
	   getBrowser("Browser");
	   
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }
   
   
}
