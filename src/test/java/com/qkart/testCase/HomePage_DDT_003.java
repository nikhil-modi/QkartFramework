package com.qkart.testCase;

import org.testng.annotations.Test;

import com.qkart.PageObject.HomePageQkart;

public class HomePage_DDT_003 extends Login_DDT_002 {
	
	@Test
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
}
