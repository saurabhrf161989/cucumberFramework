package com.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.org.Utility.Screenshot;
import com.org.Utility.Helper;

public class CustomerModalPage {

	
	WebDriver driver ;
	
	
	 public CustomerModalPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
	 @FindBy(xpath ="//button[text()='New customer']")
		public  WebElement customerType;
	 
	 @FindBy(xpath ="//button[text()='Continue']")
		public  WebElement continueButton;
	 
	 public void customerType() throws Exception{
		 
		 
		 Helper.highLightElement(driver, customerType); 
		 customerType.click();
		 Thread.sleep(3000);
		
	 }
	 
 public void continueButton() throws Exception{
		 
		 
	 Helper.highLightElement(driver, continueButton); 
	 continueButton.click();
		 Thread.sleep(8000);
		
	 }
	
	
}
