package com.qkart.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qkart.testCase.BaseClass;

public class CheckoutPage {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath = "")
	//WebElement ;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutBtn;
	
	@FindBy(xpath = "//button[@id='add-new-btn' and text()= 'Add new address']")
	WebElement addNewAddressBtn;
	
	@FindBy(xpath = "//textarea[@placeholder = 'Enter your complete address']")
	WebElement textAreaForAddress;
	
	@FindBy(xpath = "//button[text()='Add']")
	WebElement addressAddBtn;
	
	@FindBy(xpath = "//input[@type='radio' and @name = 'address']")
	WebElement addressRadioBtn;
	
	@FindBy(xpath = "//button[text()='PLACE ORDER']")
	WebElement palceOrderBtn;
	
	BaseClass bc = new BaseClass();
	
	public void clickCheckOutbtn() {
		checkOutBtn.click();
	}
	
	public void clickAddAddressBtn() {
		addNewAddressBtn.click();
	}
	
	public void enterAddress() {
		textAreaForAddress.sendKeys("rasulpur rohta near canara bank 250502 uttarpradesh");
	}
	
	public void clickAddBtn() {
		addressAddBtn.click();
	}
	
	public void clickRadioBtn() {
		addressRadioBtn.click();
	}
	
	public void clickPlaceOrderBtn() {
		bc.scrollMethod(palceOrderBtn);
		palceOrderBtn.click();
	}
}
