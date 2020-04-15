package androidCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import AmazonPageObjects.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;




public class androidCapabilities2 
{
   public static AndroidDriver<AndroidElement> driver;
   public static ResourceBundle rb;
   public static ResourceBundle ele;
   
   public WebDriverWait wait;
   
   public static ExtentReports extentReport;
   public ExtentTest extentTest;
   
   public static Logger log=LogManager.getLogger(androidCapabilities2.class.getName());
   
   public static ThreadLocal<AndroidDriver<AndroidElement>> tdriver= new ThreadLocal<AndroidDriver<AndroidElement>>();
     
   @BeforeTest
  // All test classes use this
   public AndroidDriver<AndroidElement> methodLevelSetup () throws MalformedURLException
	{
    
	    
	    log.info("Config properties gets uploaded");
    	rb=ResourceBundle.getBundle("Config");
    	
		System.out.println("LOG-check"+extentReport);
    	extentReport= new ExtentReports("./Report/report.html",true);
		extentReport.addSystemInfo("Framework", "APPIUM");
		System.out.println("LOG-check"+extentReport);

		
				
		DesiredCapabilities cap= new DesiredCapabilities();
		
		log.info("Android Device setting gets intialized");
		cap.setCapability("udid",rb.getString("udid"));
		cap.setCapability("platformName",rb.getString("platformName"));
        cap.setCapability("platformVersion",rb.getString("platformVersion"));
        cap.setCapability("deviceName",rb.getString("deviceName"));
        cap.setCapability("appPackage",rb.getString("appPackage"));
        cap.setCapability("appActivity",rb.getString("appActivity"));
        cap.setCapability("noReset",rb.getString("noReset"));
		cap.setCapability("fullReset",rb.getString("fullReset"));
       // cap.setCapability("appWaitPackage",rb.getString("appWaitPackage"));
       //cap.setCapability("appWaitActivity",rb.getString("appWaitActivity"));
	  //cap.setCapability("browserName",rb.getString("browserName"));
		
		  
		  
		log.info("Android driver get intialized" + " " + driver);		
		driver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait= new WebDriverWait(driver, 30);
		tdriver.set(driver);
		return getDriver();
		
		
	}
   
   public static synchronized AndroidDriver<AndroidElement> getDriver() {
	      
		  // System.out.println("step0" + " "+ driver );
		   return tdriver.get();
	      
	   }
   
   
   public WebDriver getDriver01() {
       return driver;
   }
   
   
   
  @AfterTest
   public void teardown()
   {
	  extentReport.flush();
	  driver.quit();
	  
	 // extentReport.close();
   }
  
  public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
		
       
	}
  
    
   
}
