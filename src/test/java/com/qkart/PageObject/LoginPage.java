package com.qkart.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement loginUsername;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement loginPassword;
	
	@FindBy(xpath = "//button[text()='Login to QKart']")
	WebElement loginToQkartBtn;
	
	@FindBy(xpath = "//button[text()='Logout']")
	WebElement logOutBtn;
	
	//optional locator if required
	
	@FindBy(xpath = "//button[text()='Back to explore']")
	WebElement backToExploreBtn;
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void setUserName(String uName) {
		loginUsername.sendKeys(uName);
	}
	
	public void setPassword(String pwd) {
		loginPassword.sendKeys(pwd);
	}
	
	public void loginToQkartBtn() {
		loginToQkartBtn.click();
	}
	
	public void clickLogOutBtn() {
		logOutBtn.click();
	}
	
	
}
