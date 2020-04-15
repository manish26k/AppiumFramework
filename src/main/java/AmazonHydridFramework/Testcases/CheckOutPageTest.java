package AmazonHydridFramework.Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import AmazonPageObjects.CartPage;
import AmazonPageObjects.CheckOutPage;
import AmazonPageObjects.LoginPage;
import AmazonPageObjects.SearchPage;
import androidCapabilities.androidCapabilities2;

public class CheckOutPageTest extends androidCapabilities2 {
	
	CheckOutPage cop;
	LoginPage lp;
	
	@Test(dependsOnGroups= {"CartPage"},description="Performed CheckOutPage Process")
	public void prodCheckOut() throws InterruptedException	{
		
		//CheckOutPage
		
		
		cop= new CheckOutPage(driver,wait);
		lp= new LoginPage(driver, wait);		
		
		if((driver.findElement(By.xpath(ele.getString("Withoutloginxpath")))).isDisplayed()) {
    		
			lp.loginIntoApp("ash@gmail.com","abc@123456");	
	    	}
		
	       else {
	    	   cop.checkOutPageInfo("121009","gurgaon","Haryana","Phase IV block A");
	    	  
	       }
		
	}

}
