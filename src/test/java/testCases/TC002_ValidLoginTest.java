package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPageObj;
import pageObjects.HomePageObj;
import pageObjects.MyAccountPageObj;
import testBase.BaseClass;

public class TC002_ValidLoginTest extends BaseClass{
	
	@Test
	public void TC002_validLoginTest() {
		
		logger.info("*** TC002_ValidLoginTest | Start ***");
		
		HomePageObj home = new HomePageObj(driver);
		home.clickMyAccount();
		home.clickLogin();
		
		AccountLoginPageObj acct = new AccountLoginPageObj(driver);
		//acct.setEmailAddress(property.getProperty("email"));
		acct.setEmailAddress("JPJloginId");
		acct.setPassword(property.getProperty("pass"));
		acct.clickLogin();
		
		MyAccountPageObj myAcct = new MyAccountPageObj(driver);
		
		if(myAcct.checkDispMyAccount()) {
			Assert.assertTrue(myAcct.checkDispMyAccount());
			logger.info("*** TC002_ValidLoginTest | end | Successful ***");
		}else {
			logger.info("*** TC002_ValidLoginTest | end | failed ***");
			Assert.assertTrue(myAcct.checkDispMyAccount());
		}
		
		
	}
	
	
}//class
