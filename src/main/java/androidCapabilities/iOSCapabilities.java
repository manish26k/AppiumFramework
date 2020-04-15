package androidCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iOSCapabilities
{
   public static ResourceBundle rb;

	public static IOSDriver<IOSElement> Capabilities() throws MalformedURLException
	{
		IOSDriver<IOSElement> driver;
     	
     	rb=ResourceBundle.getBundle("Config");
		
				
		DesiredCapabilities cap= new DesiredCapabilities();
		
		cap.setCapability("udid",rb.getString("udid"));
        cap.setCapability("platformName",rb.getString("platformName"));
        cap.setCapability("platformVersion",rb.getString("platformVersion"));
        cap.setCapability("deviceName",rb.getString("deviceName"));
        
        cap.setCapability("appPackage",rb.getString("appPackage"));
       // cap.setCapability("appWaitPackage",rb.getString("appWaitPackage"));
        
		cap.setCapability("appActivity",rb.getString("appActivity"));
		//cap.setCapability("appWaitActivity",rb.getString("appWaitActivity"));
         
        
        //cap.setCapability("browserName",rb.getString("browserName"));
 		driver= new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
 		
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
}
