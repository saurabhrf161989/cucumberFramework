package com.org.Utility;

import java.io.File;



import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Screenshot {


	
		public static void captureScreenShot(WebDriver driver,String ssc,String ss) throws Exception{
			
          try{
	
        	
        	 
        	  
        	  
        	  
	       TakesScreenshot ts=(TakesScreenshot)driver;
			 File src=ts.getScreenshotAs(OutputType.FILE);           
			
			// now copy the  screenshot to desired location using copyFile method
			 String projDir=System.getProperty("user.dir");
			 FileUtils.copyFile(src, new File(projDir +"\\Screenshots\\"+ssc+"\\"+ss+".png")); 
			                                           
			
			
               }
        catch(Exception e)
              {
	         System.out.println(e.getMessage());
	           }

             }
}
