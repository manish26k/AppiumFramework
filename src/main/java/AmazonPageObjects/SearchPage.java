package AmazonPageObjects;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SearchPage {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	ResourceBundle ele;

	public SearchPage(AndroidDriver<AndroidElement> driver, WebDriverWait w) {
		this.driver = driver;
		this.wait = w;
		ele = ResourceBundle.getBundle("Element");

	}

	public void ProdSearch(String text) throws InterruptedException {
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele.getString("Searchtextidxpath"))));
		driver.findElement(By.id(ele.getString("Searchtextidxpath"))).click();

		Thread.sleep(3000);

		

		driver.findElement(By.id(ele.getString("Searchtextidxpath"))).sendKeys("mobile ");
		Thread.sleep(3000);

		AndroidElement w = driver.findElement(By.id(ele.getString("SearchSuggestionlistviewidxpath")));
		List<MobileElement> l = w.findElements(By.className(ele.getString("Prodlistviewclassxpath")));

		System.out.println("Product size from the search textbox" + " " + l.size());

		for (int i = 0; i < l.size(); i++) {

			// System.out.println("Item on index "+i+" is "+ l.get(i).getText());

			Thread.sleep(1000);

			if (l.get(i).getText().contentEquals(text)) {
				l.get(i).click();
				break;

			}
		}

	}

	public void clickProduct() throws InterruptedException {

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className((ele.getString("Productlistxpath")))));

		List<AndroidElement> a = driver.findElements(By.className((ele.getString("Productlistxpath"))));

		System.out.println("From Product page " + a.size());
		

		for (int j = 0; j < a.size(); j++) {
			
			String text = "Samsung Guru 1200 (Gold)";

			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ text + "\").instance(0))"));
			Thread.sleep(3000);

			driver.findElement(By.xpath(ele.getString("productxpath"))).click();
			break;

		}

	}

	public void clickMobilecolor() throws InterruptedException {
		
		
		
		driver.findElement(By.xpath(ele.getString("colourbuttonclassxpath"))).click();
		Thread.sleep(1000);
		
		/*String text= "blue from 4 sellers";
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceIdMatches(\":id/twister-experiment-bottom-sheet-container\")).getChildByText("+ "new UiSelector).resourceIdMatches(\":id/color_name_2\"), \"" + text + "\")"));*/
		
		driver.findElement(By.id(ele.getString("mobileColoridxpath"))).click();
		
		
		
		
		
		
		
		
		
		
		
		
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(ele.getString("mobileColorxpath"))));
		
		
        /* Thread.sleep(2000); 
		List<AndroidElement> b = driver.findElements(By.xpath((ele.getString("mobileColorxpath"))));
		
		System.out.println("Number of color of mobile" + " " + b.size());

		for (int k = 0; k < b.size(); k++) {
			System.out.println("Item on index " + k + " is " + b.get(k).getText());
			
			if(b.get(k).getText().contentEquals(color)) {
				b.get(k).click();
				//driver.findElement(By.xpath(ele.getString("donebuttonxpath"))).click();
				
			}
		}*/

		//return new CartPage(driver, wait);
	}
	
	
	public CartPage clickAddtoCart() throws InterruptedException
	{
		String text= "Add to Cart";
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ text + "\").instance(0))"));
		
		driver.findElement(By.xpath(ele.getString("AddtoCartxpath"))).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((ele.getString("Donexpath")))));
		
		driver.findElement(By.xpath(ele.getString("Donexpath"))).click();
		
		driver.findElementByName(ele.getString("Appiconxpath")).click();
		 
			
		return new CartPage(driver, wait);
		
	}
	
	
	
	
	

	public void clickProdfromSearch(String text) throws InterruptedException {
		ProdSearch(text);
	}

	public void clickfromProdList() throws InterruptedException {
		clickProduct();
	}
	
	public void selectColor() throws InterruptedException {
		clickMobilecolor();
	}
	
	public void addProdtoCart() throws InterruptedException {
		clickAddtoCart();
		
	}

	

}


    /*driver.navigate().back();
	driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	break;*/





