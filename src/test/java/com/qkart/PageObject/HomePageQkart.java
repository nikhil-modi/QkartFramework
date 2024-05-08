package com.qkart.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qkart.testCase.BaseClass;

public class HomePageQkart {
	
	WebDriver driver;
	
	
	public HomePageQkart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath = "")
	//WebElement ;
	
	@FindBy(xpath = "//img[@alt='Stylecon 9 Seater RHS Sofa Set ']/..//button[text()='Add to cart']")
	WebElement sofaSetAddToCartBtn;
	
	@FindBy(xpath = "//img[@alt='YONEX Smash Badminton Racquet']/..//button[text()='Add to cart']")
	WebElement YonexRctAddToCartBtn;
	
	@FindBy(xpath = "//select[@id='uncontrolled-native']")
	WebElement sizeChartSelection ;
	
	@FindBy(xpath = "//img[@alt='Roadster Mens Running Shoes']/..//button[text()='Add to cart']")
	WebElement RoadsterShoesAddToCartBtn;
	

	
	BaseClass bc = new BaseClass();
	
	public void addSofa() {
		
		bc.scrollMethod(sofaSetAddToCartBtn);
		sofaSetAddToCartBtn.click();
		
	}
	
	public void addRacket() {
		bc.scrollMethod(YonexRctAddToCartBtn);
		YonexRctAddToCartBtn.click();
	}
	
	public void selectSize() {
		Select sel = new Select(sizeChartSelection);
		sel.selectByVisibleText("8");
	}
	
	public void addShoe() {
		RoadsterShoesAddToCartBtn.click();
	}

}
