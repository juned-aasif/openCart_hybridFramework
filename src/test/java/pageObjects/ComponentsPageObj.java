package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ComponentsPageObj extends BasePageObj {

	public ComponentsPageObj(WebDriver driver) {
		super(driver);
	}
	
	Actions action = new Actions(driver);
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[3]/a")
	WebElement lnkComponent;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")
	WebElement lnkMonitors;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")
	WebElement lnkAppleCinema30;
	
	
	
	public void clickOn(String moniter) {
		switch (moniter.toLowerCase()) {
		case("monitors"): action.moveToElement(lnkComponent).click(lnkMonitors).build().perform();
		}
	}
		
	public void clickOnProduct(String prod){
		switch(prod.toLowerCase()) {
		case("apple cinema 30"): lnkAppleCinema30.click();
		}
	}
		
}
	
