package hotellogin;




import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import beanjava.HotelBookingPageFactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import beanjava.HotelBookingPageFactory;

public class HotelLoginStepDef {

	private WebDriver driver;
	private HotelBookingPageFactory objhbpf;
	
	
	@Given("^User is on booking page$")
	public void user_is_on_booking_page() throws Throwable {
		driver = new FirefoxDriver();
		   //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   Thread.sleep(1000);
		   objhbpf = new HotelBookingPageFactory(driver);
		   driver.get("file:///D:/Users/nirohill/Desktop/hotelbooking.html");
	}

	@Then("^check the heading of page$")
	public void check_the_heading_of_page() throws Throwable {
		 String title = driver.getTitle();
		    if(title.equals("Hotel Booking")) {
		    	System.out.println("Title Correct");
		    }else {
		    	System.out.println("Title Wrong!");
		    }
	}

	@When("^User does not enter firstname , lastname$")
	public void user_does_not_enter_firstname_lastname() throws Throwable {
		objhbpf.setPffirstName("");
		   objhbpf.setPflastName("");
		   Thread.sleep(1000);
		   
		   objhbpf.setPfconfirm();
	}

	@Then("^prompt user to fill in details$")
	public void prompt_user_to_fill_in_details() throws Throwable {
		driver.switchTo().alert();
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
	    Thread.sleep(1000);
	    objhbpf.setPffirstName("Nitish");
	    Thread.sleep(1000);
	    objhbpf.setPflastName("Rohilla");
	    //Thread.sleep(1000);
	    //driver.close();
	}

	@When("^User does not enter email in correct format$")
	public void user_does_not_enter_email_in_correct_format() throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    Thread.sleep(1000);
	    objhbpf.setPflastName("Rohilla");
	
		objhbpf.setPfemail("");
	    Thread.sleep(1000);
	    objhbpf.setPfconfirm();
	}

	@Then("^prompt user to write input correctly$")
	public void prompt_user_to_write_input_correctly() throws Throwable {
		driver.switchTo().alert();
		   Thread.sleep(1000);
		   driver.switchTo().alert().accept();
		   Thread.sleep(2000);
		   objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
		   //Thread.sleep(1000);
		  // driver.close();
	}

	@When("^User does not enter mobile number$")
	public void user_does_not_enter_mobile_number() throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    
	    objhbpf.setPflastName("Rohilla");
	    objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
		objhbpf.setPfphone("");
	    Thread.sleep(1000);
	    objhbpf.setPfconfirm();
	}

	@Then("^prompt user to enter mobile number$")
	public void prompt_user_to_enter_mobile_number() throws Throwable {
		 driver.switchTo().alert();
		    Thread.sleep(1000);
		    driver.switchTo().alert().accept();
		    Thread.sleep(1000);
		    objhbpf.setPfphone("7057036642");
		   // Thread.sleep(1000);
		    //driver.close();
	}

	
		@When("^User enters incorrect mobileNo format and clicks the button$")
	
	public void user_enters_incorrect_mobileNo_format_and_clicks_the_button(DataTable arg1) throws Throwable {
	   
		objhbpf.setPffirstName("Nitish"); Thread.sleep(1000);
		objhbpf.setPflastName("Rohilla"); Thread.sleep(1000);
		objhbpf.setPfemail("Rohilla.Nitish1@gmail.com"); Thread.sleep(1000);
		
		List<String> objList = arg1.asList(String.class);
		
		
		
		for(int i=0; i<objList.size();i++) {
			
			objhbpf.getPfphone().clear();
			objhbpf.setPfphone(objList.get(i)); Thread.sleep(1000);
			objhbpf.setPfconfirm();
			
			driver.switchTo().alert();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			if(Pattern.matches("^[7-9]{1}[0-9]{9}$", objList.get(i))) {
				System.out.println("*******MATCHED "+ objList.get(i)+" **************");
			}else {
				System.out.println("*******NOT MATCHED "+ objList.get(i)+" **************");
			}
				}
		objhbpf.setPfconfirm();
	}

	@Then("^display alert msg$")
	public void display_alert_msg() throws Throwable {
	    driver.switchTo().alert();
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
	   // driver.close();
	 
	}
	
	/*@When("^User does not select number of people$")
	public void user_does_not_select_number_of_people() throws Throwable {
	    
	}

	@Then("^prompt user to select the number of people$")
	public void prompt_user_to_select_the_number_of_people() throws Throwable {
	   
	}

	@When("^User does not address$")
	public void user_does_not_address() throws Throwable {
	    
	}

	@Then("^prompt user to fill in the address$")
	public void prompt_user_to_fill_in_the_address() throws Throwable {
	    
	}*/

	@When("^User does not select city$")
	public void user_does_not_select_city() throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    objhbpf.setPflastName("Rohilla");
	    objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
	    objhbpf.setPfphone("7057036642");
	    
		objhbpf.setPfcity("Select City");
		objhbpf.setPfconfirm();
	}

	@Then("^prompt user to select city$")
	public void prompt_user_to_select_city() throws Throwable {
		driver.switchTo().alert();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		objhbpf.setPfcity("Pune");
		//Thread.sleep(1000);
		//driver.close();
	}

	@When("^User does not select state$")
	public void user_does_not_select_state() throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    objhbpf.setPflastName("Rohilla");
	    objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
	    objhbpf.setPfphone("7057036642");
	    objhbpf.setPfcity("Pune");
	    objhbpf.setPfstate("Select State");
		objhbpf.setPfconfirm();
	}

	@Then("^prompt user to select state$")
	public void prompt_user_to_select_state() throws Throwable {
		driver.switchTo().alert();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		objhbpf.setPfstate("Maharashtra");
		//Thread.sleep(1000);
		//driver.close();
	}
	
	
	@When("^user enters (\\d+)$")
	public void user_enters(String arg1) throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    objhbpf.setPflastName("Rohilla");
	    objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
	    objhbpf.setPfphone("7057036642");
	    objhbpf.setPfcity("Pune");
	    objhbpf.setPfstate("Maharashtra");
	    objhbpf.setPfpersons(arg1);
		Thread.sleep(1000);
	   
	}

	@Then("^(\\d+)allocate(\\d+)$")
	public void allocate(int arg1, int arg2) throws Throwable {
		System.out.println("********Rooms"+arg2);
		if(arg1<=3)
			assertEquals(1,arg2);
		else if (arg1<=6)
		assertEquals(2,arg2);
		else if(arg1<=9)
		assertEquals(3,arg2);
}

	@When("^User does not enter card holder name$")
	public void user_does_not_enter_card_holder_name() throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    objhbpf.setPflastName("Rohilla");
	    objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
	    objhbpf.setPfphone("7057036642");
	    objhbpf.setPfcity("Pune");
	    objhbpf.setPfstate("Maharashtra");
	    objhbpf.setPfpersons("4");
		objhbpf.setPfcardholderName("");
	   objhbpf.setPfconfirm();
	}

	@Then("^prompt user to fill in card holder name$")
	public void prompt_user_to_fill_in_card_holder_name() throws Throwable {
		driver.switchTo().alert();
		   Thread.sleep(1000);
		   driver.switchTo().alert().accept();
		   objhbpf.setPfcardholderName("Nitish");
		  // Thread.sleep(1000);
		  // driver.close();
	}

	@When("^User does not enter debit card number$")
	public void user_does_not_enter_debit_card_number() throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    objhbpf.setPflastName("Rohilla");
	    objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
	    objhbpf.setPfphone("7057036642");
	    objhbpf.setPfcity("Pune");
	    objhbpf.setPfstate("Maharashtra");
	    objhbpf.setPfpersons("4");
	    objhbpf.setPfcardholderName("Nitish");
		objhbpf.setPfdebit("");
	    objhbpf.setPfconfirm();
	}

	@Then("^prompt user to enter debit card number$")
	public void prompt_user_to_enter_debit_card_number() throws Throwable {
		driver.switchTo().alert();
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
	    Thread.sleep(1000);
	    objhbpf.setPfdebit("789456123");
	  //  Thread.sleep(1000);
	   // driver.close();
	}

	@When("^User does not enter card expiration month$")
	public void user_does_not_enter_card_expiration_month() throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    objhbpf.setPflastName("Rohilla");
	    objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
	    objhbpf.setPfphone("7057036642");
	    objhbpf.setPfcity("Pune");
	    objhbpf.setPfstate("Maharashtra");
	    objhbpf.setPfpersons("4");
	    objhbpf.setPfcardholderName("Nitish");
	    objhbpf.setPfdebit("789456123");
	    objhbpf.setPfcvv("555");
		objhbpf.setPfmonth("");
	    objhbpf.setPfconfirm();
	}

	@Then("^prompt user to enter card expiration month$")
	public void prompt_user_to_enter_card_expiration_month() throws Throwable {
		driver.switchTo().alert();
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
	    objhbpf.setPfmonth("05");
	   // Thread.sleep(1000);
	   // driver.close();
	}

	@When("^User does not enter card expiration year$")
	public void user_does_not_enter_card_expiration_year() throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    objhbpf.setPflastName("Rohilla");
	    objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
	    objhbpf.setPfphone("7057036642");
	    objhbpf.setPfcity("Pune");
	    objhbpf.setPfstate("Maharashtra");
	    objhbpf.setPfpersons("4");
	    objhbpf.setPfcardholderName("Nitish");
	    objhbpf.setPfdebit("789456123");
	    objhbpf.setPfcvv("555");
	    objhbpf.setPfmonth("05");
		objhbpf.setPfyear("");
	    objhbpf.setPfconfirm();
	}

	@Then("^prompt user to enter card expiration year$")
	public void prompt_user_to_enter_card_expiration_year() throws Throwable {
		driver.switchTo().alert();
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
	    objhbpf.setPfyear("2018");
	   // Thread.sleep(1000);
	    driver.close();
	}

	@When("^User clicks on confirm booking button$")
	public void user_clicks_on_confirm_booking_button() throws Throwable {
		objhbpf.setPffirstName("Nitish");
	    objhbpf.setPflastName("Rohilla");
	    objhbpf.setPfemail("Rohilla.Nitish1@gmail.com");
	    objhbpf.setPfphone("7057036642");
	    objhbpf.setPfcity("Pune");
	    objhbpf.setPfstate("Maharashtra");
	    objhbpf.setPfpersons("4");
	    objhbpf.setPfcardholderName("Nitish");
	    objhbpf.setPfdebit("789456123");
	    objhbpf.setPfcvv("555");
	    objhbpf.setPfmonth("05");
	    objhbpf.setPfyear("2018");
	    objhbpf.setradiogender("male");
	    objhbpf.setcheckbox("dinner");
	    objhbpf.setcheckbox("lunch");
	    
		objhbpf.setPfconfirm();
	}

	@Then("^navigate to booking successful$")
	public void navigate_to_booking_successful() throws Throwable {
	//	driver.findElement(By.partialLinkText("click here")).click();
		driver.navigate().to("file:///D:/hotelBooking/success.html");
	    Thread.sleep(3000);
	    driver.close();
	}
	
	
	
	
}
