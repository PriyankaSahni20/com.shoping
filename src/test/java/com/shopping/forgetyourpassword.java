package com.shopping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class forgetyourpassword {
	
	WebDriver driver =null;



@Test
public void forgetYourPassword()
{
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=password']"));	
}


}