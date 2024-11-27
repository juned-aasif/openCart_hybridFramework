package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pageObjects.MyAccountPageObj;
import testBase.BaseClass;

public class TC006_LaptopNNotebookOptions extends BaseClass {
	
	@Test
	public void tC006_LaptopNNotebookOptions() {
		
		logger.info("***TC006_LaptopNNotebookOptions | Start ***");
		
		TC002_ValidLoginTest login = new TC002_ValidLoginTest();
		
		MyAccountPageObj myAccount = new MyAccountPageObj(driver);
		
		List<String> actualOption_LaptopNNotebook = myAccount.getOptionsLaptopNNoteBook();
		
	}
	
	

}
