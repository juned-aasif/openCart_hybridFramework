package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DesktopPageObj extends BasePageObj {
	
	public DesktopPageObj(WebDriver driver){
		super(driver);
	}
	
	//Desktops 
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
	WebElement lnkDesktop;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[1]/a")
	WebElement lnkPc;
	
	@FindBy(xpath="//div[@id=\"content\"]//h2[1]")
	WebElement txtPc;

	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")
	WebElement lnkMac;
	
	@FindBy(xpath="//div[@id=\"content\"]//h2")
	WebElement txtMac;
	
	
	
	public void clickOnPc() {
		Actions action = new Actions(driver);
		action.moveToElement(lnkDesktop).moveToElement(lnkPc).click().build().perform();
	}
	
	public String getTextPc() {
		return txtPc.getText();
	}
	
	public void clickOnMac(){
		Actions action = new Actions(driver);
		action.moveToElement(lnkDesktop).moveToElement(lnkMac).click().build().perform();
	}
	
	public String getTextMac(){
		return txtMac.getText();
	}
	
	

}
