package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPageObj;
import pageObjects.HomePageObj;
import pageObjects.MyAccountPageObj;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void TC003_loginDDT(String email, String pass, String exp) throws InterruptedException {
		
		try {
			logger.info("*** TC003_LoginDDT | START ***");
			
			HomePageObj home = new HomePageObj(driver);
			home.clickMyAccount();
			home.clickLogin();
			
			AccountLoginPageObj acct = new AccountLoginPageObj(driver);
			acct.setEmailAddress(email);
			acct.setPassword(pass);
			acct.clickLogin();
			
			MyAccountPageObj myAcct = new MyAccountPageObj(driver);

			//boolean myAcctDisp = myAcct.checkDispMyAccount();
			String curTitle= myAcct.getTitleMyAccount();
			logger.info(curTitle);
			
			/*
			 * Below check is not handling invalid scenarios
			if(exp.equalsIgnoreCase("valid")) {
				
				if(myAcct.checkDispMyAccount()) {
					myAcct.clickLogOut();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
			}else {
				if(myAcct.checkDispMyAccount()) {
					myAcct.clickLogOut();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
				}
			}
			*/
			
			if(exp.equalsIgnoreCase("valid")) {
				if(curTitle.equals("My Account")) {
					myAcct.clickLogOut();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
			}else {
				if(curTitle.equals("My Account")) {
					myAcct.clickLogOut();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
				}
			}
			
			
		}catch(Exception e){
			Assert.assertTrue(false);
		}
		
		
	}//method

}// class
