package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public String[][] getLoginData() throws IOException{
		String path ="./testData/loginTestData.xlsx";
		
		ExcelUtility xlUtil= new ExcelUtility(path);
		
		int rowCount = xlUtil.getRowcount("LoginTestDataSheet");
		int clmCount = xlUtil.getCellCount("LoginTestDataSheet", 1);
		
		String loginData[][] = new String[rowCount][clmCount];
		
		// getting data from excel file and storing in 2*2 array
		for(int i=1; i<= rowCount; i++) {
			for(int j=0; j<clmCount; j++) {
				loginData[i-1][j]= xlUtil.getCellData("LoginTestDataSheet", i, j);
			}
		}
		
		return loginData;
	}

}
