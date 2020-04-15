package AmazonPageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SignUpPage{
	
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	ResourceBundle ele;
	
	
	
	@SuppressWarnings("rawtypes")
	protected TouchAction touchAction;
      
	
	public SignUpPage(AndroidDriver<AndroidElement> driver,WebDriverWait w)
	{
		this.driver=driver;
		this.wait=w;
		ele=ResourceBundle.getBundle("Element");
		
		
		
	}
	
	
	public void enterName(String Name) throws InterruptedException
	{
		
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(ele.getString("Nameid"))));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele.getString("Nameid")))).isDisplayed();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele.getString("Name")))).isDisplayed();
		driver.findElement(By.xpath(ele.getString("Name"))).click();
		driver.findElement(By.xpath(ele.getString("Name"))).sendKeys(Name);
		
	}
	
	
	public void clickCountryCode() throws InterruptedException 
	{

		driver.findElement(By.xpath(ele.getString("countrycode"))).click();
		String text = "Zambia";
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
		
		
		
		

		/*while (driver.findElements(By.xpath("(//android.view.View[contains(@text,'Mexico')])")).size() > 0) {
			this.swipePage("DOWN");
		}
		
		while (driver.findElements(By.xpath("(//android.view.View[contains(@text,'Mexico')])")).size() != 0) {
			//this.swipePage("DOWN");
			this.swipePage();
		}
		
		while (!driver.findElements(By.xpath("(//android.view.View[contains(@text,'Mexico')])")).isEmpty()) {
			this.swipePage("DOWN");
		}*/
		
		
		
		
		
		
		
		

		driver.findElement(By.xpath("(//android.view.View[contains(@text,'Zambia')])")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele.getString("Mobileph"))));

	}

	public Dimension getScreenDimensions() {
		return driver.manage().window().getSize();
	}

	public TouchAction getTouchAction() {
		return this.touchAction != null ? this.touchAction : (this.touchAction = createTouchAction());
	}

	protected TouchAction<AndroidTouchAction> createTouchAction() {
		return new TouchAction<AndroidTouchAction>(driver);
	}

	public void swipePage(String direction)
	{
		Dimension size = this.getScreenDimensions();
		int startY = (int) (size.getHeight() * 0.70);
		int endY = (int) (size.getHeight() * 0.55);
		int startX = size.width / 2;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		if (direction.equalsIgnoreCase("UP"))
			this.getTouchAction().longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY))
					.release().perform();
		else if (direction.equalsIgnoreCase("DOWN"))
			this.getTouchAction().longPress(PointOption.point(startX, endY)).moveTo(PointOption.point(startX, startY))
					.release().perform();
		
		
	}
	
	
	public void swipePage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("xpath", "(//android.view.View[contains(@text,'Mexico')])");
        js.executeScript("mobile: scroll", scrollObject);	
        
        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void swipePage1(String direction)
	{
		Dimension size = this.getScreenDimensions();
		int startY = (int) (size.getHeight() * 0.70);
		int endY = (int) (size.getHeight() * 0.55);
		int startX = size.width / 2;
		
		
		if (direction.equalsIgnoreCase("UP"))
			 new TouchAction(driver) 
					.press(PointOption.point(startX, startY)) 
					//.waitAction(waitOptions(ofMillis(800))) 
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
					.moveTo(PointOption.point(startX, endY)) 
					.release() 
					.perform(); 
			else if (direction.equalsIgnoreCase("DOWN"))
				 new TouchAction(driver) 
				.press(PointOption.point(startX, startY)) 
				//.waitAction(waitOptions(ofMillis(800))) 
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
				.moveTo(PointOption.point(startX, endY)) 
				.release() 
				.perform();	
		
	}*/
	

	
	
	
/*public void enterMobile(String Phonenumber)
	{
		driver.findElement(By.xpath(ele.getString("Mobileph"))).sendKeys(Phonenumber);
	}
	
	public void enterEmail(String Email)
	{
		driver.findElement(By.xpath(ele.getString("Email"))).sendKeys(Email);
		
	}
	
	public void enterPassword(String Pass)
	{
		driver.findElement(By.xpath(ele.getString("Password"))).sendKeys(Pass);
		
		driver.hideKeyboard();
	}
	
	public void clickVerifyMobilebutton()
	{
		driver.findElement(By.xpath(ele.getString("VerifyMobile"))).click();
	}*/
	
	
	
	
	
	
	
	
	
	
	

	public void SignUp(String Name,String Phonenumber, String Email, String Pass) throws InterruptedException
	{
		//enterName(Name);
		clickCountryCode();
		/*enterMobile(Phonenumber);
    	enterEmail(Email);
		enterPassword(Pass);
		clickVerifyMobilebutton();*/
		
	}
	
	
	
	
	
	
	
	
	/*public  void  clickCountryCode() throws InterruptedException
	{
		
		driver.findElement(By.xpath(ele.getString("countrycode"))).click();
		
		
		
		String text="Algeria +213";
		
		AndroidElement country=driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector().resourceIdMatches(\".*id/auth-country-picker_3\")).scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"));"));
		
			String text="Japan +81";
			AndroidElement elementList = driver.findElement(MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector().resourceIdMatches(\".*id/auth-country-picker_98\")).setMaxSearchSwipes(5).scrollIntoView("
	                + "new UiSelector().text(\""+text+"\"));"));
		
		
		elementList.click();
		
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele.getString("Mobileph"))));
	
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void RegInfo()
	{
		wait = new WebDriverWait(driver, 30);
		WebElement SignUptxtfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele.getString("TextFieldclassxpath"))));
		
		List<AndroidElement> textFields=driver.findElements(By.className(ele.getString("TextFieldclassxpath")));
		System.out.println(textFields);
		
		textFields.get(0).sendKeys("Manish");
		textFields.get(1).sendKeys("1111122222");
		textFields.get(2).sendKeys("ash26rana@gmail.com");
		textFields.get(3).sendKeys("f1shb0ne");
		//driver.findElement(By.xpath(ele.getString("VerifyMobilexpath"))).click();
		
	}*/
	
	


}
