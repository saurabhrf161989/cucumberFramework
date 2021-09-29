package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.org.Utility.Screenshot;
import com.org.Utility.Helper;

public class DeviceProtectionPage {

	
	WebDriver driver ;
	
	
	 public DeviceProtectionPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
	 @FindBy(xpath ="//input[@name='checkboxall']")
		public  WebElement selectDevice;
	 
	 @FindBy(xpath ="//div/h2[contains(text(),' Total Mobile Protection')]/parent::div/parent::div/following-sibling::div[2]/button")
		public  WebElement deviceProtection;
	
	 @FindBy(xpath ="//span[text()='Continue']")
		public  WebElement continueButton;
	 
	 
	 public void deviceCheck() throws Exception{
		 
		 
		 System.out.println("device protection ");
		 Helper.highLightElement(driver, selectDevice); 
		 selectDevice.click();
		 
		 Thread.sleep(3000);
		
	 }
	 
	 
	 
 public void deviceProtection(String protectionName) throws Exception{
		 
		 
	 
	 driver.findElement(By.xpath("//div/h2[contains(text(),' "+protectionName+"')]/parent::div/parent::div/following-sibling::div[2]/button")).click();
	 Thread.sleep(3000);
		
	 }
 
 public void continueButton() throws Exception{
	 
	 
	 Helper.highLightElement(driver, continueButton); 
	 continueButton.click();
	 Thread.sleep(7000);
	
 }
	
	
}
