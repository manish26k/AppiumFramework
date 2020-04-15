package AmazonHydridFramework.Testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AmazonPageObjects.SignUpPage;
import AmazonPageObjects.WelcomePage;
import androidCapabilities.androidCapabilities2;

public class SignUpPageTest extends androidCapabilities2
{
	WelcomePage wp;
	SignUpPage sp;
	
	
	@Test
	public void signup() throws InterruptedException
	{
		wp= new WelcomePage(driver,wait);
		wp.clickonSignup();
		
		sp= new SignUpPage(driver,wait);
		sp.SignUp("Mani23","9999988888","ash@gmail.com","abc@123456");
		
		
	}
	
	
	
	
	
	
}
