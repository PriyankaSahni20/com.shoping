package com.shoping.com.shoping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {
	
	public static WebDriver setup(String url)
	
	{
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup(); 
		 driver = new ChromeDriver();
		

		
//		  WebDriverManager.firefoxdriver().setup();
//		  driver = new FirefoxDriver(); 
	     driver.manage().window().maximize();
	     driver.get(url);
	     return driver;
	}

}
