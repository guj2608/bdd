package hotellogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelleniumBooking {

	public static void main(String[] args) throws Exception{
	WebDriver driver =new FirefoxDriver();
	driver.get("file:///D:/Module%203/hotelBooking/hotelbooking.html");
	
	
	/***********Blank First Name****************/
	driver.findElement(By.id("txtFirstName")).sendKeys("");
	driver.findElement(By.id("btnPayment")).click();
	driver.switchTo().alert();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	/************Valid First Name*****************/
	driver.findElement(By.id("txtFirstName")).sendKeys("Nitish");
	
	
	
	/***********Blank Last Name****************/
	driver.findElement(By.id("txtLastName")).sendKeys("");
	driver.findElement(By.id("btnPayment")).click();
	driver.switchTo().alert();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	
	
	
	/************Valid Last Name*****************/
	driver.findElement(By.id("txtLastName")).sendKeys("Rohilla");

	/***********Blank Email****************/
	driver.findElement(By.id("txtEmail")).sendKeys("");
	driver.findElement(By.id("btnPayment")).click();
	driver.switchTo().alert();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	
	
	
	/***********Invalid Email****************/
	driver.findElement(By.id("txtEmail")).sendKeys("a.com");
	driver.findElement(By.id("btnPayment")).click();
	driver.switchTo().alert();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	
	
	
	/************Valid Email*****************/
	driver.findElement(By.name("Email")).clear();
	driver.findElement(By.id("txtEmail")).sendKeys("nitish.rohilla@gmail.com");
	

	
	/***********Blank Phone Number****************/
	driver.findElement(By.id("txtPhone")).sendKeys("");
	driver.findElement(By.id("btnPayment")).click();
	driver.switchTo().alert();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	
	
	
	/*************For invalid Phone Number************/
	driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).sendKeys("5432112345");
	driver.findElement(By.id("btnPayment")).click();
	driver.switchTo().alert();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	

	/************Valid Phone Number*****************/
	driver.findElement(By.id("txtPhone")).sendKeys("7057036642");
	
	
	
	/***********Blank City****************/
	Select sel = new Select(driver.findElement(By.name("city")));
	sel.selectByVisibleText("Select City");
	driver.findElement(By.id("btnPayment")).click();
	driver.switchTo().alert();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	
	
	/************Valid City*****************/

	 sel.selectByVisibleText("Pune");
	
	
	 
	 /***********Blank State****************/
		Select sel1 = new Select(driver.findElement(By.name("state")));
		sel1.selectByVisibleText("Select State");
		//sel1.deselectByValue("Maharashtra");
		//sel1.deselectByValue("Tamilnadu");
		//sel1.deselectByValue("Karnataka");
		//sel1.deselectByValue("Telangana");
		driver.findElement(By.id("btnPayment")).click();
		driver.switchTo().alert();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	

		/************Valid State*****************/
	
		 sel1.selectByVisibleText("Maharashtra");
		 
		 
			/***********Blank Card Holder Name****************/
			driver.findElement(By.id("txtCardholderName")).sendKeys("");
			driver.findElement(By.id("btnPayment")).click();
			driver.switchTo().alert();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			/************Valid Card Holder Name*****************/
			driver.findElement(By.id("txtCardholderName")).sendKeys("Nitish");
			
		
			
			/***********Blank Debit Card Number****************/
			driver.findElement(By.id("txtCardHolderName")).sendKeys("");
			driver.findElement(By.id("btnPayment")).click();
			driver.switchTo().alert();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			/************Valid Debit Card Number*****************/
			driver.findElement(By.id("txtCardHolderName")).sendKeys("1234567890");
			
			
			/***********Blank CVV****************/
			driver.findElement(By.id("txtCvv")).sendKeys("");
			driver.findElement(By.id("btnPayment")).click();
			driver.switchTo().alert();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			/************Valid CVV*****************/
			driver.findElement(By.id("txtCvv")).sendKeys("1234567890");
			
	
	driver.close();
	
}


}



