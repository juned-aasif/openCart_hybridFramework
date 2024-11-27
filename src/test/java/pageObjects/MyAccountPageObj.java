package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageObj extends BasePageObj {
	
	public MyAccountPageObj(WebDriver driver){
		super(driver);
	}
	
	// locators
	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	WebElement disTextMyAccount;
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	WebElement lnkLogOut;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[2]/a")
	WebElement lnkLapNNote;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[2]/div/div/ul/li")
	List<WebElement> allOptionsLapNNote; 
	
	public boolean checkDispMyAccount() {
		return disTextMyAccount.isDisplayed();
	}
	
	public void clickLogOut() {
		lnkLogOut.click();
	}
	
	public String getTitleMyAccount() {
		return (driver.getTitle());
	}
	
	public List<String> getOptionsLaptopNNoteBook() {
		List<String> allOptionList = new ArrayList<String>();
		for(WebElement i: allOptionsLapNNote) {
			allOptionList.add(i.getText());
		}
		return allOptionList;
	}
	
	public boolean compareList(List<String> list1, List<String> list2) {
		if(list1.size() != list2.size()) {
			return false;
		}else {
			for(int i=0; i<= list1.size(); i++) {
				if(!list1.get(i).equals(list2.get(i))) {
					return false;
				}
			}
		}
		return true;
	}
	

}
