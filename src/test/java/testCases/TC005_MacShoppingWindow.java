package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopPageObj;
import testBase.BaseClass;

public class TC005_MacShoppingWindow extends BaseClass{
	
	@Test
	public void tC005_MacShoppingWindow() {
		
		logger.info("***TC005_MacShoppingWindow | Start");
		TC002_ValidLoginTest login = new TC002_ValidLoginTest();
		DesktopPageObj desktop = new DesktopPageObj(driver);
		desktop.clickOnMac();
		String confirmText = desktop.getTextMac();
		
		logger.info(confirmText);
		
		Assert.assertEquals(confirmText,"Mac");
		
	}
	
}
