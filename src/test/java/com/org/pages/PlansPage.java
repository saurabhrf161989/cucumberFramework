package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.org.Utility.Helper;
import com.org.Utility.Screenshot;

public class PlansPage {

	
	WebDriver driver ;
	
	
	 public PlansPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
	 @FindBy(xpath ="//input[@name='checkboxall']")
		public  WebElement selectDevice;
	 
	 @FindBy(xpath ="//p[text()=' Business Unlimited Plus']/following-sibling::div[2]//button[text()=' Select Plan ']")
		public  WebElement plan;
	
	 @FindBy(xpath ="//span[text()='Continue']")
		public  WebElement continueButton;
	 public void deviceCheck() throws Exception{
		 
		 
		 System.out.println("plans page ");
		 Helper.highLightElement(driver, selectDevice); 
		 selectDevice.click();
		 Thread.sleep(3000);
		
	 }
	 
 public void planSelect(String planName) throws Exception{
		 
		 
	  driver.findElement(By.xpath("//p[text()=' "+planName+"']/following-sibling::div[2]//button[text()=' Select Plan ']")).click();
		 Thread.sleep(3000);
		
	 }
 
 public void continueButton() throws Exception{
	 
	 
	 Helper.highLightElement(driver, continueButton); 
	 continueButton.click();
	 Thread.sleep(10000);
	
 }
	
	
}
