package com.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import com.org.Utility.Helper;

import com.org.Utility.Screenshot;

public class PDPPage {

	
	WebDriver driver ;
	
	
	 public PDPPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
	 @FindBy(xpath ="//span[text()='Add to cart']")
		public static WebElement addToCart;
	 
	 public void addToCart() throws Exception{
		 
		 System.out.println("pdp page ");
		 Helper.highLightElement(driver, addToCart); 
		 addToCart.click();
		 
		 Thread.sleep(4000);
		 
	 }
	
	
}
