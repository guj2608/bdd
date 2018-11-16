package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selleniumlogin  {
	public static void main(String args[]) throws Exception {
		
		WebDriver driver=new FirefoxDriver();
		
		
		
		//to check the heading
		
		driver.get("file:///D:/Module%203/hotelBooking/login.html");
		String strheading=driver.findElement(By.xpath(".//*[@id='ab']")).getText();
		
		if(strheading.contentEquals("Email Registration"))
		{
			System.out.println("heading matched");
		}
		else {
			System.out.println("Heading Not Matched");
		}
		
		
		
		//to make it wait for 30 seconds
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(5000);
		
	
	//Login page
	
	//*******
		driver.findElement(By.name("userName")).sendKeys("capgemini"); 
		driver.findElement(By.name("userPwd")).sendKeys("capg1234");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		
		driver.findElement(By.className("btn")).click();
		
		
//		String alertMessage=driver.switchTo().alert().getText();
//		System.out.println(alertMessage);
//		driver.switchTo().alert().accept();
//	
		
	//	Thread.sleep(5000);
		
		//to navigate to a particular page
		//driver.navigate().to("");
		
		
		
		//hotel booking page
		//driver.findElement(By.name("txtFN")).sendKeys("nitish"); 
		
//		System.out.println(driver.getCurrentUrl());
		
	}}