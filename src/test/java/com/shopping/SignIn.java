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


import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class SignIn {
	String Email = "priyankasahniiiiii@gmail.com";
	
	
	
	
	static WebDriver driver;
	@BeforeClass
	public void setupsuiteandlaunch() throws InterruptedException
		{
		
		WebDriverManager.chromedriver().setup(); 
		 driver = new ChromeDriver();
		 driver.get("http://automationpractice.com/index.php");
		 driver.manage().window().maximize();
		 	 }
	@Test
	public void createaccount() throws InterruptedException
		{
		
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@class='login']")).click();
			//driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]/@href")).click();
			
			//driver.findElement(By.xpath("//div[@class='form-group form-error']/label[contains(text(),'Email address')]")).sendKeys("test@123.com");
			
			driver.findElement(By.id("email_create")).sendKeys(Email);
			
			//driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium exclusive'][.//span[contains(text(), '')]]")).click();
			//driver.findElement(By.id("SubmitCreate")).click();
			driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
			
		}
			
	@Test
	public void register() throws InterruptedException
	
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
			 WebElement  mrsRadioBtn = driver.findElement(By.id("id_gender2"));
			 //Checking if the Mrs Radio button is enabled on the webpage and printing the status
            boolean radioBtnIsEnabled = mrsRadioBtn.isEnabled();
            Assert.assertTrue(driver.findElement(By.id("id_gender2")).isEnabled());  
            //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());  
           // System.out.println("Is Mrs radio button enabled: "+radioBtnIsEnabled);
            
            //Selecting mrs radio button
            mrsRadioBtn.click();
            //Checking the radio button selection status

            boolean radioBtnIsSelected = mrsRadioBtn.isSelected();
            Assert.assertTrue(driver.findElement(By.id("id_gender2")).isSelected()); 
            
            //System.out.println("Default Radio button selection Status: "+radioBtnIsSelected);
            // //input[@id='customer_firstname']
            driver.findElement(By.id("customer_firstname")).sendKeys("Priyanka");
            driver.findElement(By.name("customer_lastname")).sendKeys("Sahni");
            
            WebElement EmailField =  driver.findElement(By.id("email"));
            String Emailverify = EmailField.getAttribute("value"); // as value is the attribute of the priyankasahni09@gmail.com
			
            Assert.assertEquals(Email,Emailverify);
            
            //EmailField.click();
            driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Admin@123");
            driver.findElement(By.id("days")).sendKeys("10");
            driver.findElement(By.id("months")).sendKeys("October");
            driver.findElement(By.id("years")).sendKeys("1994");
            // Select days = new Select(driver.findElement(By.id("days")));
            //days.selectByValue("9");
           
            driver.findElement(By.xpath("//input[@name='newsletter']")).click();
            driver.findElement(By.xpath("//div[@id='uniform-optin']")).click();
           
           // driver.findElement(By.id("firstname")).sendKeys("Priyanka");
           
          //  driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Sahni");   
           
            driver.findElement(By.id("address1")).sendKeys("12 test , delhi");
           
            driver.findElement(By.name("city")).sendKeys("delhi");
            
            driver.findElement(By.xpath("//select[@name='id_state']")).sendKeys("Indiana");
            
            driver.findElement(By.id("postcode")).sendKeys("11000");
            
        //driver.findElement(By.xpath("//select[@id='id_country']")).sendKeys("United States");
            
            // In selenium they had created a class Select for selected dropdown values and creating select object of Select class
          Select Country = new Select(driver.findElement(By.xpath("//select[@name='id_country']")));

          WebElement Countryoption = Country.getFirstSelectedOption();

          String defaultItem = Countryoption.getText();
          
          // Select Country = new Select(driver.findElement(By.id("id_country")));
          // String DefaultValue = Country.getFirstSelectedOption().getText();
         
       if(defaultItem != null)
       {
    	   System.out.println(defaultItem);   
       }
       
       else
       {
    	 //option.selectByVisibleText("United States");
    	   Country.selectByVisibleText("United States");
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
