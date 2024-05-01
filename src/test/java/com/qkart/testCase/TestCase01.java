package com.qkart.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qkart.PageObject.LoginPage;

public class TestCase01 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		driver.get(url);
		
		logger.info("opening the browser");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.clickLoginBtn();
		lp.setUserName(uName);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.loginToQkartBtn();
		
		if(driver.getTitle().equals("QKart")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}else {
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		
		
		
	}
}
