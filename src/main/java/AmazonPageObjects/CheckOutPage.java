package AmazonPageObjects;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CheckOutPage {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	ResourceBundle ele;
	
	
	//Constructor
    public CheckOutPage(AndroidDriver<AndroidElement> driver, WebDriverWait w)	{
		this.driver = driver;
		this.wait = w;
		ele = ResourceBundle.getBundle("Element");

	}
	
	
	
	public void enterPinCode(String pincode){
		
		driver.findElement(By.id(ele.getString("pincodeidxpath"))).sendKeys(pincode);
	}
	
	public void enterTownCity(String Towncity) {
		driver.findElement(By.id(ele.getString("towncityidxpath"))).sendKeys(Towncity);
	}
	
	public void enterState(String state) {
		driver.findElement(By.id(ele.getString("stateidxpath"))).sendKeys(state);
	}
	
	public void enterAddress(String address) {
		driver.findElement(By.id(ele.getString("addressidxpath"))).sendKeys(address);
	}
		
		
	public void checkOutPageInfo(String pincode,String Towncity,String state,String address ) {
		enterPinCode(pincode);
		enterTownCity(Towncity);
		enterState(state);
		enterAddress(address);
		
		
	}
	
	
	
	
	
	
	

}
