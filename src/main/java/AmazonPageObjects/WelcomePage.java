package AmazonPageObjects;

import java.net.MalformedURLException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WelcomePage 
{
      
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	ResourceBundle ele;
	
	
	public WelcomePage(AndroidDriver<AndroidElement> driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		ele=ResourceBundle.getBundle("Element");
	}
	
	
	public SignUpPage clickonSignup() throws InterruptedException
	{
		
		driver.findElement(By.xpath(ele.getString("Signupxpath"))).click();
		
		
						
		return new SignUpPage(driver, wait);
	}
	
	public LoginPage clickonSignIn()
	{
		driver.findElement(By.xpath(ele.getString("SignInxpath"))).click();
		
		return new LoginPage(driver, wait);
	}
	
	public SearchPage clickSkipSignIn() {
		
		
		
		driver.findElement(By.xpath(ele.getString("SkipSignInxpath"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele.getString("Searchtextidxpath"))));
		return new SearchPage(driver, wait);
	}
	
	

}
