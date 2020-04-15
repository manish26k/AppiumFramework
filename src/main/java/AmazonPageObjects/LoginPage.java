package AmazonPageObjects;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;



public class LoginPage
{
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	ResourceBundle ele;
	

	public LoginPage(AndroidDriver<AndroidElement> driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		ele=ResourceBundle.getBundle("Element");
		
	}
	
	@Step("Enter MObileorEmail in TextField")
	public void enterMobileorEmail(String MobileEmail)
	{
	
		driver.findElement(By.xpath(ele.getString("MobileorEmailxpath"))).clear();
		driver.findElement(By.xpath(ele.getString("MobileorEmailxpath"))).sendKeys(MobileEmail);
		driver.hideKeyboard();
	}
	
	@Step("Click on continueButton")
	public void clickContinuebutton()
	{
		driver.findElement(By.className(ele.getString("Continuebuttonclassxpath"))).click();
		
	}
	
	@Step("Enter password in TextField")
	public void enterPassword(String Password)
	{
		driver.findElement(By.xpath(ele.getString("Passwordxpath"))).sendKeys(Password);
		
	}
	
	@Step("Click on loginButton then SearchPage is displayed")
	public SearchPage clickLoginbutton()
	{
	
		driver.findElement(By.xpath(ele.getString("Loginbuttonxpath"))).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele.getString("Searchtextidxpath"))));
		return new SearchPage(driver,wait);
	}
	
	@Step("It Will Navigate to checkoutPage")
	public CheckOutPage Loginbutton() {
		
		driver.findElement(By.xpath(ele.getString("Loginbuttonxpath"))).click();
		return new CheckOutPage(driver,wait);
		
	}
	
	@Step("This Method will displayed searchPage once user gets login ")
	public void loginIntoApp(String MobileEmail, String Password)
	{
		enterMobileorEmail(MobileEmail);
		clickContinuebutton();
		enterPassword(Password);
		clickLoginbutton();
	
	}
	
	@Step("This Method after login displayed CheckOutPage")
	public void loginApp(String MobileEmail, String Password)
	{
		enterMobileorEmail(MobileEmail);
		clickContinuebutton();
		enterPassword(Password);
		Loginbutton();
	
	}


}
