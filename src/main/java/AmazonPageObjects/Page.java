package AmazonPageObjects;

import org.openqa.selenium.support.ui.WebDriverWait;


import androidCapabilities.androidCapabilities2;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Page extends androidCapabilities2
{
	 public AndroidDriver<AndroidElement> driver;
	 public WebDriverWait wait;
	
    //Constructor
    public Page(AndroidDriver<AndroidElement> driver,WebDriverWait wait){
        
    	this.driver = driver;
        this.wait = wait;
    }
 
    //JAVA Generics to Create and return a New Page
    public  <TPage extends androidCapabilities2> TPage GetInstance (Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(AndroidDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
