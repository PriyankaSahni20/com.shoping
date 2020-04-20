package com.shopping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.shoping.com.shoping.Constants;
import com.shoping.com.shoping.ReusableMethods;

public class SignOut extends Login {
	
	
@Test
public void signOut()

{
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[@class='logout']")).click();
	
	
}
	
}
