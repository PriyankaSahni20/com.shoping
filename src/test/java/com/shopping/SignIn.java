package com.shopping;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shoping.com.shoping.Constants;
import com.shoping.com.shoping.ReusableMethods;


import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class SignIn {
	static WebDriver driver;
	String Email = "priyankasais4i78ffd99@gmail.com";
	String validColor = "#35b33f";
	
	
	
	
@BeforeClass
	public  void setupsuiteandlaunch() 
	{
		
	
	driver= ReusableMethods.setup(Constants.url);

		
		 	 }
	@Test
	public void createaccount() 
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='login']")).click();
		  
			
			driver.findElement(By.id("email_create")).sendKeys(Email);
			
			driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
			
		}
			
	@Test
	public void register() throws InterruptedException
	
	{
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			 WebElement  mrsRadioBtn = driver.findElement(By.id("id_gender2"));
			 //Checking if the Mrs Radio button is enabled on the webpage and printing the status
            boolean radioBtnIsEnabled = mrsRadioBtn.isEnabled();
            Assert.assertTrue(driver.findElement(By.id("id_gender2")).isEnabled());  
           
            //Selecting mrs radio button
            mrsRadioBtn.click();
            //Checking the radio button selection status

            boolean radioBtnIsSelected = mrsRadioBtn.isSelected();
            Assert.assertTrue(driver.findElement(By.id("id_gender2")).isSelected()); 
            
            //System.out.println("Default Radio button selection Status: "+radioBtnIsSelected);
           
            driver.findElement(By.id("customer_firstname")).sendKeys("Priyanka");
            driver.findElement(By.name("customer_lastname")).sendKeys("Sahni");
            
            WebElement emailField =  driver.findElement(By.id("email"));
            String emailVerify = emailField.getAttribute("value"); 
            Assert.assertEquals(Email,emailVerify);
           emailField.click();
           WebElement passwordField = driver.findElement(By.xpath("//input[@name='passwd']"));
           passwordField.click();
           passwordField.sendKeys("Admin@123");
             
             String Color = driver.findElement(By.id("email")).getCssValue("color");
             System.out.println(Color);
             String hex = String.format("#%02x%02x%02x", 53,179,63,1);
             System.out.println(hex);
             Assert.assertEquals(validColor, hex);
            

             driver.findElement(By.id("days")).sendKeys("10");
            driver.findElement(By.id("months")).sendKeys("October");
            driver.findElement(By.id("years")).sendKeys("1994");
           
           
            driver.findElement(By.xpath("//input[@name='newsletter']")).click();
            driver.findElement(By.xpath("//div[@id='uniform-optin']")).click();
           
           driver.findElement(By.id("firstname")).sendKeys("nn");
           
           driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("ss");   
           
            driver.findElement(By.id("address1")).sendKeys("12 test , delhi");
           
            driver.findElement(By.name("city")).sendKeys("delhi");
            
            driver.findElement(By.xpath("//select[@name='id_state']")).sendKeys("Indiana");
            
            driver.findElement(By.id("postcode")).sendKeys("11000");
            
          Select country = new Select(driver.findElement(By.xpath("//select[@name='id_country']")));

          WebElement countryOption = country.getFirstSelectedOption();

          String defaultItem = countryOption.getText();
          
        
         
       if(defaultItem.equalsIgnoreCase("-"))
       {
    	   System.out.println(defaultItem);   
       }
       
       else
       {
    	 
    	   country.selectByVisibleText("United States");
       }
        
        driver.findElement(By.name("phone_mobile")).sendKeys("9898989899");
      
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("My Address");
       
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click(); 
        
            		
		}
			@AfterClass	
	 public void teardown()
	 {
	driver.quit();
		
	}
	
	}
