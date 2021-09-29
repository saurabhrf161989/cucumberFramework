package com.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import com.org.Utility.Helper;

import com.org.Utility.Screenshot;

public class ZipCodeModalPage {

	
	WebDriver driver ;
	
	
	 public ZipCodeModalPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
	 @FindBy(xpath ="//input[@id='zipcode']")
		public  WebElement zipcode;
	 
	 @FindBy(xpath ="//button[text()='Save ']")
		public  WebElement saveButton;
	 
	 public void zipCode() throws Exception{
		 
		 
		 Helper.highLightElement(driver, zipcode);
		 zipcode.sendKeys("94203");
		 Thread.sleep(3000);
		
	 }
	 
 public void saveButton() throws Exception{
		 
		 
	 Helper.highLightElement(driver, saveButton);
	     saveButton.click();
		 Thread.sleep(5000);
		
	 }
	
	
}
