package AmazonHydridFramework.Testcases;

import java.net.MalformedURLException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AmazonPageObjects.TestAllureListener;

import com.relevantcodes.extentreports.LogStatus;

import AmazonPageObjects.CartPage;
import AmazonPageObjects.LoginPage;
import AmazonPageObjects.WelcomePage;

import androidCapabilities.androidCapabilities2;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import io.qameta.allure.*;


@Listeners({TestAllureListener.class})
@Feature("LoginPage Test")

public class LoginPageTest extends androidCapabilities2
{
     
	LoginPage lp;
	
	@Test(groups= {"LoginPage"},dependsOnGroups= {"WelcomePage"},description="Navigate to LoginPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Valid Gmail: {0} and Password: {1}")
	public void login()
	{
		/*WelcomePage wp= new WelcomePage(driver,wait);
		wp.clickonSignIn();*/
	
		//SoftAssert softAssert = new SoftAssert();
		log.info("Login Page Test Case");
		
		lp= new LoginPage(driver, wait);
		System.out.println("LOG"+extentReport);
		extentTest = extentReport.startTest("ValidLoginPageTestCase","Login Into AmazonApp");
		
		
		
		//softAssert.assertTrue(false);
		log.info("Valid Email and Password");
		lp.loginIntoApp("ash26ranagmail.com","f1shb0ne");
		extentTest.log(LogStatus.PASS, "LoginTestCase Passed");
		extentReport.endTest(extentTest);
		
		
		//softAssert.assertAll();
		
		
		
		
		
	}
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
     
     
     
     
     
     
     
     
     
     
     
     
}
