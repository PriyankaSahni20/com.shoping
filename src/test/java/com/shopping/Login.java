package com.shopping;



import org.testng.annotations.Test;
import com.shoping.com.shoping.Constants;
import com.shoping.com.shoping.ReusableMethods;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Login {
	
	WebDriver driver =null;
	

	public WebDriver login()
{
	
	 
driver = ReusableMethods.setup(Constants.url);
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.findElement(By.xpath("//a[@class='login']")).click();
driver.findElement(By.xpath("//input[@id='email']")).sendKeys("priyankasahni09@gmail.com");
 driver.findElement(By.id("passwd")).sendKeys("Admin@123");
 driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
 return driver;

}

@Test

public void loginToSite()

{
	
	login();
	
}

}

