package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopPageObj;
import testBase.BaseClass;

public class TC004_PCShoppingWindow extends BaseClass{
	
	@Test
	public void tc004_pcShoppingWindow() {
		
		logger.info("***TC004_PCShoppingWindow | Start***");
		
		TC002_ValidLoginTest login = new TC002_ValidLoginTest();
		
		DesktopPageObj desktop =  new DesktopPageObj(driver);
		desktop.clickOnPc();
		String navConfirmPc = desktop.getTextPc();
		
		logger.info(navConfirmPc);
		
		if(navConfirmPc.equals("PC")) {
			logger.info("Pass");
			Assert.assertTrue(true);
		}else {
			logger.info("Failed");
			Assert.assertTrue(false);
		}
	}
}
