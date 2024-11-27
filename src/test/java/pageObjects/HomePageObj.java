package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObj extends BasePageObj{
	WebDriver driver;
	
	public HomePageObj(WebDriver driver) {
		super(driver);
	}
	
	
	// locators
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement lnkRegister;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement lnkLogin;
	
	// action methods
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	

}//class
