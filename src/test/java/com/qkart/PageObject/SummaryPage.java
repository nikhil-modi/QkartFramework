package com.qkart.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
	
	WebDriver driver;
	
	public SummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath = "")
	//WebElement ;
	
	@FindBy(xpath = "//div[@id='root']//h2")
	WebElement orderedText;
	
	@FindBy(xpath = "//button[@id='continue-btn' and text()= 'Continue Shopping']")
	WebElement contShoppingBtn;
	
	public void verifyOrderedText() {
		if(orderedText.isDisplayed()) {
			
			System.out.println(orderedText.getText());
		}
		else {
			System.out.println("Order is not placed");
		}
	}
	
	public void clickContinueShopping() {
		contShoppingBtn.click();
	}
}
