package com.qkart.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qkart.PageObject.LoginPage;
import com.qkart.utilities.XLUtils;

public class Login_DDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String userName, String pwd) throws InterruptedException {
		
		driver.get(url);
		logger.info("opening the browser");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.clickLoginBtn();
		lp.setUserName(userName);
		lp.setPassword(pwd);
		Thread.sleep(5000);
		lp.loginToQkartBtn();
		Thread.sleep(2000);
		lp.clickLogOutBtn();
		
		
		if(driver.getTitle().equals("QKart")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}
	
	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/qkart/testData/LoginData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path,"Sheet1", 1);
		
		String [][] loginData = new String[rowNum][colCount];
		
		for(int i=1; i<=rowNum; i++) {
			for(int j=0; j<colCount; j++) {
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
	}

}
