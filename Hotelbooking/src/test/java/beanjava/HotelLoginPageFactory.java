package beanjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HotelLoginPageFactory {
	
	
	WebDriver driver;
	//Step1:Identify the elements
	
	@FindBy(name="userName")
	WebElement pfuname;
	

	//how class
	
	@FindBy(how=How.NAME,using="userPwd")
	WebElement pfupwd;
	
	@FindBy(className="btn")
	WebElement pflogin ;

	

	//initiating the elements
	public  HotelLoginPageFactory(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public void setPfuname(String suname) {
		pfuname.sendKeys(suname);;
	}



	public void setPfupwd(String supwd) {
		pfupwd.sendKeys(supwd);;
	}



	public void setPflogin() {
		pflogin.click();
	}
	
	public WebElement getPfuname() {
		return pfuname;
	}
	
	public WebElement getPfupwd() {
		return pfupwd;
	}
	
	
	
	
}

	
	
	
	
	
	


