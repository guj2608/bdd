package login;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import beanjava.HotelLoginPageFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	WebDriver driver;
	HotelLoginPageFactory hlpf;

	
	
	
	
	@Given("^User is on the login page$")
	public void user_is_on_the_login_page() throws Exception {
        driver=new FirefoxDriver();
        hlpf=new HotelLoginPageFactory(driver);
		driver.get("file:///D:/hotelBooking/login.html");
	    
	}

	@Then("^check the heading of the page$")
	public void check_the_heading_of_the_page() throws Exception {
//		String strheading=driver.findElement(By.xpath(".//*[@id='mainCnt']/div/div[1]/h1")).getText();
		String strheading = driver.findElement(By.xpath(".//*[@id='mainCnt']/div[1]/div[1]/h1")).getText();
		if(strheading.contentEquals("Hotel Booking Application"))
		{
			System.out.println("heading matched");
		}
		else {
			System.out.println("Heading Not Matched");
		}
		
	}


	
	@When("^user enters valid username,valid password$")
	public void user_enters_valid_username_valid_password() throws Exception {
	    hlpf.setPfuname("capgemini");
	    hlpf.setPfupwd("capg1234");
	    Thread.sleep(2000);
	   }
	
	@When("^Clicks the login button$")
	public void clicks_the_login_button() throws Exception {
	    hlpf.setPflogin();
	    
	}


	@Then("^navigate to hotel booking$")
	public void navigate_to_hotel_booking() throws Exception {
		driver.navigate().to("file:///D:/hotelBooking/hotelbooking.html");
		Thread.sleep(2000);
	driver.close();
	    
	}


	
	
	@When("^user doesnot enter username or password$")
	public void user_doesnot_enter_username_or_password() throws Exception {
	    hlpf.setPfuname("");
	 //   hlpf.setPfupwd("");
	    hlpf.setPflogin();
	    Thread.sleep(2000);
	}

	

	@Then("^display appropriate message$")
	public void display_appropriate_message() throws Exception {
	   String str=driver.findElement(By.xpath(".//*[@id='userErrMsg']")).getText();
	   assertEquals(str,"* Please enter userName.");
	//   driver.close();
	   
	}

	@When("^user enters incorrect username or password$")
	public void user_enters_incorrect_username_or_password() throws Exception {
		   hlpf.setPfuname("jhgjhg");
		    hlpf.setPfupwd("capg1234");
		    hlpf.setPflogin();
		    Thread.sleep(2000);
	}

	@Then("^displaylogin failed message$")
	public void displaylogin_failed_message() throws Exception {
		String alertMessage=driver.switchTo().alert().getText();
		System.out.println("alert message"+alertMessage);
		driver.switchTo().alert().accept();
		driver.close();
	}

}
