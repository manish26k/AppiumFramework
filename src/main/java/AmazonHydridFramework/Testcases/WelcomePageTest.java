package AmazonHydridFramework.Testcases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import androidCapabilities.androidCapabilities2;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import AmazonPageObjects.TestAllureListener;
import AmazonPageObjects.WelcomePage;


@Listeners({TestAllureListener.class})
@Feature("WelcomePage Test")


public class WelcomePageTest extends androidCapabilities2
{
	
	WelcomePage wp;
	
	@Test @Ignore
	public void amazonSignUp() throws InterruptedException
	{
		
		wp.clickonSignup();
	}
	
	
	
	
	@Test(priority = 0,groups= {"WelcomePage"}, description="WelcomePage with SignInbutton")
	@Severity(SeverityLevel.NORMAL)
	@Story("Amazon SignIn button")
	public void amazonSignIn()
	{
		
		log.info("Amazon Welcome Page SignIn Test Case");
		wp= new WelcomePage(driver, wait);
		
		extentTest= extentReport.startTest("Amazon WelcomePageTestCase","click On SignInbutton");
		
		log.info("Click on SignInbutton");
		wp.clickonSignIn();
		
		extentTest.log(LogStatus.PASS, "Welcome_signInTestCase Passed");
		extentReport.endTest(extentTest);
		
	}
	
	@Test (groups= {"SkipSignIn"}, description="WelcomePage with SkipSignInbutton") @Ignore
	public void amazonSkipSignIn() {
		wp.clickSkipSignIn();
	}

}
