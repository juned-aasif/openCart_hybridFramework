package testCases;

import java.awt.AWTException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPageObj;
import pageObjects.AddToCartPageObj;
import pageObjects.ComponentsPageObj;
import pageObjects.HomePageObj;
import testBase.BaseClass;
import utilities.RobotFileUpload;

public class TC006_AddToCart extends BaseClass {
	
	@Test
	public void tC006_AddToCart() throws InterruptedException, AWTException{
		
		logger.info("Start  |  TC006_BuyUnavailableProduct");
		
		//login
		HomePageObj home = new HomePageObj(driver);
		home.clickMyAccount();
		home.clickLogin();
		
		AccountLoginPageObj acct = new AccountLoginPageObj(driver);
		acct.setEmailAddress(property.getProperty("email"));
		acct.setPassword(property.getProperty("pass"));
		acct.clickLogin();
		
		// navigation: component > Monitors
		ComponentsPageObj comp = new ComponentsPageObj(driver);
		comp.clickOn("monitors");
		comp.clickOnProduct("apple cinema 30");
		
		// fill details in add cart form
		AddToCartPageObj addCart = new AddToCartPageObj(driver);
		addCart.clickOnRadio();
		addCart.clickOnCheckbox();
		addCart.enterText("This is text");
		addCart.selectColor("1");
		addCart.enterTextArea("This is textArea");
		addCart.clickOnUploadFile();
		
		RobotFileUpload flUpld = new RobotFileUpload();
		flUpld.uploadFile(System.getProperty("user.dir")+"\\filesToUpload\\testFileUpload.pdf");
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	
		addCart.clickAddCart();	
		
		if(addCart.checkSuccessMessage()) {
			Assert.assertTrue(true);
			logger.info("TC006_Monitor Add cart | Pass");
		}else {
			capScreen(getClass().getName());
			Assert.assertTrue(false);
		}
	}

}
