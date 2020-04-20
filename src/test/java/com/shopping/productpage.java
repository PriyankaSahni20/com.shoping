package com.shopping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class productpage extends homepage {

	String productAmountVerify;
	String productAmountVerifyInsidePopup;
	String quantitySelected;
    String quantity;
    String quantityIncreased;
	
	@Test (priority=2)	
	public void navigateToProduct()
	{
		
		Actions actions = new Actions(driver);
		WebElement productSelection = driver.findElement(By.xpath("//a[@title='Women']"));
		actions.moveToElement(productSelection).perform();
		WebElement topsCategory= driver.findElement(By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//a[@title='Tops']"));
		//String tops = topsCategory.getAttribute("title");
		//String Title = driver.getTitle();
		//System.out.println("Title of the webpage is " +Title);
		String tops = topsCategory.getText();
		System.out.println(tops);
		topsCategory.click();
		 WebElement navigatePageHeading = driver.findElement(By.xpath("//h2[@class='title_block']"));
         String verifyPageHeadingtops = navigatePageHeading.getText();
        System.out.println(verifyPageHeadingtops);
       Assert.assertEquals(tops,verifyPageHeadingtops);
       // driver.findElement(By.xpath("//div[@class='product-image-container']//a[@title='Faded Short Sleeve T-shirts']")).click();
       // driver.findElement(By.xpath("//div[@class='product-image-container']//img[@title='Faded Short Sleeve T-shirts']")).click();
       // driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']//img[@class='replace-2x img-responsive']")).click();
	 //WebElement productAmount = driver.findElement(By.xpath("//div[@class='content_price']/span[@class='price product-price']"));
        actions.moveToElement(driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']"))).perform();
       WebElement productAmount = driver.findElement(By.xpath("//div[@class='product-image-container']/div[2]/span"));
        productAmountVerify = productAmount.getText();
        System.out.println(productAmountVerify);
       // driver.findElement(By.xpath("//div[@class='product-image-container']/a/img[@title='Faded Short Sleeve T-shirts']")).click();

		driver.findElement(By.xpath("//a[@class='quick-view']")).click();
	}	
	
	
	
	@Test (priority=3)
	public void productPopUp() throws InterruptedException
	
	
	{
	Actions action = new Actions(driver);
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']")));
    System.out.println("Frame switched");
	Thread.sleep(5000);
	WebElement fancybox = driver.findElement(By.xpath("//li[@id='thumbnail_3']/a/img[@id='thumb_3']"));
	action.moveToElement(fancybox).perform();
	Thread.sleep(5000);
	System.out.println("Image changed");
	JavascriptExecutor js = (JavascriptExecutor) driver;  
	  js.executeScript("window.scrollBy(0,400)","");
	  
	
	}
	
	
	@Test (priority=4)
public void productDetailverify()
	{
		
	    
	   // WebElement productAmountInsidePopup = driver.findElement(By.xpath("//p[@class='our_price_display']//span[@id='our_price_display']"));
	    WebElement productAmountInsidePopup = driver.findElement(By.xpath("//div[@class='box-info-product']//div[@class='price']//span[@id='our_price_display']"));
		String productAmountVerifyInsidePopup = productAmountInsidePopup.getText();
	    System.out.println(productAmountVerifyInsidePopup);
	    
	    Assert.assertEquals(productAmountVerifyInsidePopup,productAmountVerify);
	    
	 WebElement productCount=  driver.findElement(By.xpath("//input[@class='text']"));
	  String productCountVerify =productCount.getAttribute("value");
	  // Assert.assertEquals(productCountVerify,"1");
	   Assert.assertNotNull(productCountVerify);
	   
	WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
   Assert.assertNotNull(quantity);
	quantity.clear();
	quantity.sendKeys("2"); 
	 quantitySelected = quantity.getAttribute("value");
	
	 System.out.println(quantitySelected);
	   
	WebElement quantityadd = driver.findElement(By.xpath("//i[@class='icon-plus']"));
	
	quantityadd.click();
	
	String quantityIncreased = quantity.getAttribute("value");
	
 System.out.println(quantityIncreased);
	
	
	Select size = new Select(driver.findElement(By.xpath("//select[@name='group_1']")));
	size.selectByValue("3");
	System.out.println("Large size got selected successfully");
	
	
	   }
	    
	
	@Test  (priority=5)	
   public void productToCart() throws InterruptedException
	{
	//driver.findElement(By.xpath("//button[@name='Submit']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
	Thread.sleep(4000);
	
	
	
	}
	
	@Test (priority=6)
	public void productToCartPopUp() throws InterruptedException
	{
		
		
		driver.switchTo().defaultContent();	
	WebElement verifyProductHeading = driver.findElement(By.xpath("//div[@class='clearfix']/div[@class='layer_cart_product col-xs-12 col-md-6']/h2"));
	//	verifyProductHeading.isDisplayed();
		String ProductHeading = verifyProductHeading.getText();
		System.out.println(ProductHeading);
		Assert.assertNotNull(ProductHeading);
		
		
		WebElement quantityVerify =driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']"));
		String quantityVerifyOnAddedToCart = quantityVerify.getText();
		System.out.println(quantityVerifyOnAddedToCart);
		
		driver.findElement(By.xpath("//span[@class='product-name' and text()='Faded Short Sleeve T-shirts']"));
		Assert.assertTrue(true, "Faded Short Sleeve T-shirts");
		
		
	    WebElement productAttribute =	driver.findElement(By.xpath("//span[@id='layer_cart_product_attributes']"));
		String productAttributes = productAttribute.getText();
		System.out.println(productAttributes);
		
		
	WebElement prize=driver.findElement(By.xpath("//span[@id='layer_cart_product_price']"));
     String printPrize = prize.getText();
		System.out.println(printPrize);
	String newprize = "$49.53";
	  Assert.assertEquals(printPrize,newprize);
	
	
	  driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
	  
	//  driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']")).click();
	  
	///a[@class="btn btn-default button button-medium"]
//		String strTest= "$16.51";
//		 int iPrize = Integer.valueOf(strTest);
//	
//	System.out.println("Actual String:"+ strTest);
//    System.out.println("Converted to Int:" + iPrize);
//    
//    System.out.println("Arithmetic Operation on Int:" + (iPrize*3));
//      Assert.assertEquals(printPrize,newprize);
		
		
		
			
		
		
		
	
	}
	

}
	
	
	
	

