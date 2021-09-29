package com.org.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.org.Utility.Screenshot;
import com.org.Utility.Helper;

public class GridwallPage {

	
	WebDriver driver ;
	
	
	 public GridwallPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
	 @FindBy(xpath ="//a[@href='/business/products/devices/smartphones/apple-iphone-se-2020']//img")
		public  WebElement device;
	 
	 @FindBy(xpath ="//span[text()='Continue']")
		public  WebElement continueButton;
	
	
	 public void deviceSelect() throws Exception{
		 
		 
		 System.out.println("gridwall page ");
		 Helper.highLightElement(driver, device);
		 device.click();
		 Thread.sleep(8000);
		
	 }
	 
 public void continueButton() throws Exception{
		 
		 
	 Helper.highLightElement(driver, continueButton);
		 continueButton.click();
		 Thread.sleep(6000);
		
	 }
	
	
}
