package AmazonPageObjects;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.env.SystemEnvironmentPropertySource;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CartPage{
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	ResourceBundle ele;

	public CartPage(AndroidDriver<AndroidElement> driver, WebDriverWait w)
	{
		this.driver = driver;
		this.wait = w;
		ele = ResourceBundle.getBundle("Element");

	}
	
	
    public void clickCart() throws InterruptedException {
    	Thread.sleep(500);	   	
        driver.findElementByAndroidUIAutomator("UiSelector().description(\"Cart\")").click();
   }
    
    public void AddqtyInCart() {
    	driver.findElement(By.xpath(ele.getString("Addqtyxpath"))).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((ele.getString("Removeqtyxpath")))));
    }
    
    public CheckOutPage clickproceed() {
    	
    	driver.findElement(By.xpath(ele.getString("ProceedtoBuybuttonxpath"))).click();
    	
    	    	
		return new CheckOutPage(driver,wait);
    	
    }
    
    
    
    
    public void Cartclickbutton() throws InterruptedException {
    	clickCart();
    }
    
    public void addProdinCart() {
    	AddqtyInCart();
    }
    
    public void clickProceed() {
    	clickproceed();
    }
	
    
    
    
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
