package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObj;
import pageObjects.RegisterAccountPageObj;
import testBase.BaseClass;


public class TC001_AccountRegistration extends BaseClass {

	@Test
	public void TC001_accountRegistration() throws InterruptedException {
		logger.info("***TC001_accountRegistration | Start ***");
		HomePageObj home = new HomePageObj(driver);
		home.clickMyAccount();
		home.clickRegister();
		
		RegisterAccountPageObj regAct = new RegisterAccountPageObj(driver);
		regAct.setFirstName(randString().toUpperCase());
		regAct.setLastName(randString().toUpperCase());
		regAct.setEmail(randString()+"@gmail.com");
		regAct.setTelephone(randNumeric());
		String password = randPass();
		regAct.setPassword(password);
		regAct.setConfirmPassword(password);
		regAct.setPrivacyPolicy();
		regAct.clickContinue();
		
		try {
			Assert.assertEquals(regAct.getTxtRegisterConfirmation(), "Your Account Has Been Created!");
		}catch(Exception e){
			Assert.assertTrue(false);
		}
		logger.info("***TC001_accountRegistration | End ***");
	}
	
	
}// class
