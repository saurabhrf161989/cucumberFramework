package com.org.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesAttributesRead {

	
	public static List cookies(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub


		
		Set<Cookie> allCookies=driver.manage().getCookies();
		
		
		List l=new ArrayList();
		
				
		for(Cookie cookie:allCookies){
			
			String domainName=cookie.getDomain();
			if(domainName.contains("verizon.com")){
				
			String name=cookie.getName();
			if(name.contains("JSESSIONIDMBT"))
			{
			System.out.println("name ----"+cookie.getName());
			System.out.println("value ----"+cookie.getValue());
			l.add(cookie.getValue());
			}
			if(name.contains("GROUP_ORDER_NUMBER"))
			{
			System.out.println("name ----"+cookie.getName());
			System.out.println("value ----"+cookie.getValue());
			l.add(cookie.getValue());
			}
			}	
		}
		
		return l;
		
	}

}
