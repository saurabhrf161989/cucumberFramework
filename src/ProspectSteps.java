package stepDefination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.org.Utility.ConfigDataProvider;
import com.org.Utility.CookiesAttributesRead;
import com.org.Utility.GetdatafromExcel;
import com.org.Utility.Screenshot;
import com.org.Utility.WritedataToExcel;
import com.org.pages.CustomerModalPage;
import com.org.pages.DeviceProtectionPage;
import com.org.pages.GridwallPage;
import com.org.pages.PDPPage;
import com.org.pages.PlansPage;
import com.org.pages.ZipCodeModalPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ProspectSteps {
	
	WebDriver driver;

	Scenario scenario;
		
	@Before
	public void setUp(Scenario scenario) throws Exception{
		
		  String projDir=System.getProperty("user.dir");
		  System.setProperty("webdriver.chrome.driver",projDir +"\\jar\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("open");	
		
		
		    this.scenario = scenario;
		
		
	}
	
	
	@Given("^user open prospect application for \"([^\"]*)\"$")
	public void user_open_prospect_application_for_env(String env) throws Throwable {
		
		String testName=scenario.getName();
		
		String envrio=GetdatafromExcel.getVal(testName, env);
		
		System.out.println("  env is =="+envrio);
		if(envrio.equals("prod")){
		driver.manage().window().maximize();
		driver.get("https://www.verizon.com/business/shop/products/devices/smartphones/");
	   Thread.sleep(8000);
	   
		}
		else{
			driver.manage().window().maximize();
			driver.get("https://www.fb.com");
		   Thread.sleep(8000);
		}
		 
		    }
	  
	
	
	
	
	@When("^user Select Devices and Accessories$")
	public void user_Select_Devices_and_Accessories() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		GridwallPage gridwallPageObj =new GridwallPage(driver);
		gridwallPageObj.deviceSelect();
		
		PDPPage PDPPageobj=new PDPPage(driver);
		PDPPageobj.addToCart();
		
		CustomerModalPage customerModalobj=new CustomerModalPage(driver);
		customerModalobj.customerType();
		customerModalobj.continueButton();
		
		//gridwallPageObj.continueButton();
		Thread.sleep(6000);
		gridwallPageObj.continueButton();
		ZipCodeModalPage zipCodeModalobj= new ZipCodeModalPage(driver);
		zipCodeModalobj.zipCode();
		zipCodeModalobj.saveButton();
		
		 
	}
	
	@And("^user Select Plans as \"([^\"]*)\" and Protection as \"([^\"]*)\"$")
	public void user_Select_Planns_and_Protection(String plan,String protection) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
     String testName=scenario.getName();
		
		String planName=GetdatafromExcel.getVal(testName, plan);
		String protectionName=GetdatafromExcel.getVal(testName, protection);
		
		System.out.println("plan is"+planName);
		System.out.println("protection is"+protectionName);
		
		PlansPage plansPageobj =new PlansPage(driver);
	//	plansPageobj.deviceCheck();
		plansPageobj.planSelect(planName);
		plansPageobj.continueButton();
		
		DeviceProtectionPage deviceProtectionPageobj= new DeviceProtectionPage(driver);
		//deviceProtectionPageobj.deviceCheck();
		deviceProtectionPageobj.deviceProtection(protectionName);
		deviceProtectionPageobj.continueButton();
		
	}

	@Then("^user should land on shopping page$")
	public void user_should_land_on_shopping_page() throws Throwable {
		
		Boolean a=driver.findElement(By.xpath("//h1[text()='Shopping Cart']")).isDisplayed();
		
		
		 Thread.sleep(3000);
				
	}


	@Then("^user should land on business info page$")

	@Then("^user should land on shipping page$")

	public void user_should_land_on_shopping_page() throws Throwable {
		
		Boolean a=driver.findElement(By.xpath("//h1[text()='Shopping Cart']")).isDisplayed();
		
		
		 Thread.sleep(3000);
				
	}



	


	
	
	@After
	public void tearDown(Scenario scenario) throws InterruptedException, IOException{
		
		
		String testName=scenario.getName();
		List a=new ArrayList();
		a=CookiesAttributesRead.cookies(driver);
		
		String groupOrderNumber=(String) a.remove(1);
		
		String JSESSIONIDMBT=(String) a.remove(0);
		WritedataToExcel.setVal(testName,groupOrderNumber,JSESSIONIDMBT);	
		System.out.println("in tear down method");
		
		driver.quit();
		
		
	}
	
}
