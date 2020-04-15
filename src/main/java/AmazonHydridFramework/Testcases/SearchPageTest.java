package AmazonHydridFramework.Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import AmazonPageObjects.LoginPage;
import AmazonPageObjects.SearchPage;
import AmazonPageObjects.WelcomePage;
import androidCapabilities.androidCapabilities2;

public class SearchPageTest extends androidCapabilities2
{
	
	
	SearchPage sp;
	
	
	@Test(groups= {"SearchPage"},description="Landing to Search Page")
	public void clickprodFromSearchSuggestionlist() throws InterruptedException
	{
		    sp= new SearchPage(driver,wait);
		    sp.clickProdfromSearch("mobile phone under 10000");
			sp.clickfromProdList();
			sp.clickAddtoCart();
		   

	}
	
	

}
