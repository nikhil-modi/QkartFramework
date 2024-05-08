package com.qkart.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qkart.PageObject.CheckoutPage;
import com.qkart.PageObject.HomePageQkart;
import com.qkart.PageObject.LoginPage;
import com.qkart.PageObject.SummaryPage;
import com.qkart.utilities.XLUtils;

public class Login_DDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData", priority = 0)
	public void loginDDT(String userName, String pwd) throws InterruptedException {
		
		driver.get(url);
		logger.info("opening the browser");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("opening the login page");
		lp.clickLoginBtn();
		logger.info("clicked the login button on home page");
		lp.setUserName(userName);
		logger.info("entered the username");
		lp.setPassword(pwd);
		logger.info("entered the password");
		lp.loginToQkartBtn();
		logger.info("clicked on the login button");
//		lp.clickLogOutBtn();
//		logger.info("clicked on the logout button");
		
		
		if(driver.getTitle().equals("QKart")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(priority = 1)
	public void addingItemsToCart() {
		logger.info("The control is on home page");
		
		HomePageQkart hpq = new HomePageQkart(driver);
		
		hpq.addSofa();
		logger.info("the sofa set is added to cart");
		
		
		hpq.addRacket();
		logger.info("the racket is added to the cart");
		
		hpq.selectSize();
		logger.info("the size for the shoes is selected before");
		
		hpq.addShoe();
		logger.info("the shoes are added to the cart");
		
		
	}
	
	@Test(priority = 2)
	public void chekoutPage() {
		logger.info("moving to checkout page");
		
		CheckoutPage cp = new CheckoutPage(driver);
		
		cp.clickCheckOutbtn();
		logger.info("click on the checkout btn");
		
		cp.clickAddAddressBtn();
		logger.info("clicked on the add address btn ");
		
		cp.enterAddress();
		logger.info("address is entered in the text box");
		
		cp.clickAddBtn();
		logger.info("add address button is clicked");
		
		cp.clickRadioBtn();
		logger.info("radio button to select the address is clicked");
		
		cp.clickPlaceOrderBtn();
		logger.info("the place order button is clicked");
	
		
		
	}
	
	@Test(priority = 3)
	public void summaryPage() {
		logger.info("moving to summary page");
		
		SummaryPage sp = new SummaryPage(driver);
		
		sp.verifyOrderedText();
		logger.info("the text present on the screen is verified if avaialable");
		
		sp.clickContinueShopping();
		logger.info("clicked on the continue button shopping");
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
