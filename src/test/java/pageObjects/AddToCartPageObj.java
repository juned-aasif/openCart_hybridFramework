package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPageObj extends BasePageObj {
	
	public AddToCartPageObj(WebDriver driver) {
		super(driver);
	}
	
	Actions action = new Actions(driver);
	
	@FindBy(xpath="//*[@id=\"input-option218\"]/div/label/input")
	WebElement radioSmall;
	
	@FindBy(xpath="//*[@id=\"input-option223\"]/div[1]/label/input")
	WebElement cbCheckBox;
	
	@FindBy(xpath="//input[@id=\"input-option208\"]")
	WebElement txtText;
	
	@FindBy(xpath="//Select[@id=\"input-option217\"]")
	WebElement ddColor;
	
	@FindBy(xpath="//*[@id=\"input-option209\"]")
	WebElement txtarea;
	
	@FindBy(xpath="//*[@id=\"button-upload222\"]")
	WebElement btnUploadFile;
	
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	WebElement butAddCart;
	
	@FindBy(xpath="//*[@id=\"product-product\"]/div[1]")
	WebElement msgAddedItemToCart;
	

	
	public void clickOnRadio() {
		radioSmall.click();
	}
	
	public void clickOnCheckbox() {
		cbCheckBox.click();
	}
	
	public void enterText(String txt) {
		txtText.sendKeys(txt);
	}
	
	public void selectColor(String value) {
		Select select = new Select(ddColor);
		select.selectByValue(value);
	}
	
	public void enterTextArea(String txt) {
		txtarea.sendKeys(txt);
	}
	
	public void clickOnUploadFile() {
		action.moveToElement(btnUploadFile).click().build().perform();
	}
	
	public void clickAddCart() {
		butAddCart.click();
	}
	
	public boolean checkSuccessMessage() {
		boolean check = msgAddedItemToCart.isDisplayed();
		return check;
	}

	
}
