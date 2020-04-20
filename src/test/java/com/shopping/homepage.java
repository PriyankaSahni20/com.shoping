package com.shopping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shoping.com.shoping.Constants;
import com.shoping.com.shoping.ReusableMethods;


public class homepage extends Login{
	
	Login lgn = new Login();
	

	public void navigateToHomePage()

	{
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.className("home")).click();
        	
	}	
	
	@Test (priority=1)	
	public void verifyheadings()
	{
		String heading1 = "WOMEN";
		String h1 = driver.findElement(By.xpath("//a[@title='Women']")).getText();
		System.out.println(h1);
		Assert.assertEquals(heading1,h1);
		String heading2 = "DRESSES";
		String h2 = driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[@title='Dresses']")).getText();
		System.out.println(h2);
		Assert.assertEquals(heading2,h2);
		String heading3 = "T-SHIRTS";
		String h3 = driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[@title='T-shirts']")).getText();
		System.out.println(h3);
		Assert.assertEquals(heading3,h3);
		
		
	}
	
	
	
	
}
	
	


