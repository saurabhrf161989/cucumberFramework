package com.org.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigDataProvider {

	
	static String projDir=System.getProperty("user.dir");
	private static String configfile=projDir + "\\Config\\Config.properties";
	
	
	public  static String readConfig(String key) throws Exception{

		 File src= new File(configfile);
			FileInputStream fis= new FileInputStream(src);
			
			Properties pro=new Properties();
			pro.load(fis);
			
			String data=pro.getProperty(key);
			
			return data;
				 }
	 
}
