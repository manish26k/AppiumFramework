package AmazonHydridFramework.Testcases;

import org.testng.annotations.Test;

import AmazonPageObjects.LoginPage;
import AmazonPageObjects.Page;
import AmazonPageObjects.CartPage;
import AmazonPageObjects.SearchPage;
import AmazonPageObjects.WelcomePage;
import androidCapabilities.androidCapabilities2;

public class CartPageTest extends androidCapabilities2
{
	
	CartPage cp;
	SearchPage sp;
	
	@Test(groups= {"CartPage"},dependsOnGroups= {"SearchPage"},description="Navigate to the Cart Page")
	public void CartPage() throws InterruptedException
	{
		
		/*sp= new SearchPage(driver,wait);
		sp.clickProdfromSearch("mobile phone under 10000");
		sp.clickfromProdList();
		sp.clickAddtoCart();*/
		
		
		
		
		cp= new CartPage(driver,wait);
		cp.clickCart();
		cp.clickproceed();
	}
	
	

}
