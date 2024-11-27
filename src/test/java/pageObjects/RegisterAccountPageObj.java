package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPageObj extends BasePageObj {
	
	WebDriver driver;
	public RegisterAccountPageObj(WebDriver driver) {
		super(driver);
	}
	
	
	//locators
	@FindBy(xpath="//input[@id='input-firstname' and @name='firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname' and @name='lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email' and @name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone' and @name='telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement checkPrivacyPolicy;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement btnContinue;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement regConfirmation;
	
	
	// action methods
	public void setFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void setPrivacyPolicy() {
		checkPrivacyPolicy.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getTxtRegisterConfirmation() {
		try {
			return regConfirmation.getText();
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	
}//class
