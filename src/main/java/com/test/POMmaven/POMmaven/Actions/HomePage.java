package com.test.POMmaven.POMmaven.Actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.POMmaven.POMmaven.TestBase.TestBase;


public class HomePage extends TestBase{
	
	public static final Logger log= Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='header_user_info']/a")
	WebElement sign;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement signbutton;
	
	@FindBy(xpath="//div[@id='center_column']/div[1]/ol/li")
	WebElement Authenticationfailed;
	
	//test case elements
	
	@FindBy(id="email_create")
	WebElement enteremail;
	
	@FindBy(id="SubmitCreate")
	WebElement CreateAccount;
	
	@FindBy(xpath="//*[@id='id_gender1']")
	WebElement MrRadiobuton;
	
	@FindBy(xpath="//*[@id='customer_firstname']")
	WebElement customerfirstname;

	@FindBy(xpath="//*[@id='customer_lastname']")
	WebElement customerlastname;

	@FindBy(xpath="//*[@id='passwd']")
	WebElement newpassworde;
	
	@FindBy(xpath="//*[@id='firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//*[@id='lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath="//*[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//*[@id='id_state']")
	WebElement state;
	
	@FindBy(xpath="//*[@id='postcode']")
	WebElement Zipcode;
	
	@FindBy(xpath="//*[@id='phone_mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//*[@id='id_country']")
	WebElement country;
	
	@FindBy(xpath="//*[@id='alias']")
	WebElement alias;
	
	@FindBy(xpath="//*[@id='submitAccount']")
	WebElement submitAccount;
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement singout;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String Uid,String Pwd){
		sign.click();
		log.info("clicked on signin link"+sign.toString());
		username.sendKeys(Uid);
		log.info("Enterted username"+username.toString());
		password.sendKeys(Pwd);
		log.info("Entered Password"+password.toString());
		signbutton.click();
		log.info("Clicked on Submit button"+signbutton.toString());
			
		
	}
	
	public void verifyRegistration() throws Exception{
		sign.click();
		log.info("clicked on sign in button");
		enteremail.sendKeys("rangas10@gmail.com");
		log.info("Entered email address");
		CreateAccount.submit();
		log.info("Clicked on CreateAccount button");
		Thread.sleep(10000);
		MrRadiobuton.click();
		log.info("Selected MR radio button");
		customerfirstname.sendKeys("xxx");
		log.info("Entered FirstName");
		customerlastname.sendKeys("kumarKK");
		log.info("Entered LastName");
		newpassworde.sendKeys("xxx12");
		log.info("Entered password");
		address1.sendKeys("IBM");
		log.info("Entered Address1");
		city.sendKeys("dubai");
		log.info("City Enetered");
		Select select=new Select(state);
		select.selectByIndex(1);
		log.info("Entered State");
		Zipcode.sendKeys("12345");
		log.info("Entered ZipCode");
		mobile.sendKeys("9123456789");
		log.info("Entered Mobile Number");
		Select select1=new Select(country);
		select1.selectByIndex(1);
		log.info("Entered Country");
		alias.sendKeys("TCS");
		log.info("Entered Address2");
		submitAccount.click();
		log.info("Clicked on Submit button");
		Thread.sleep(10000);
				
	}
	
	public boolean verifyloginmessage(){
		log.info("############### starting verifyloginmessage ###################");
		try{
		//waitforElement(3000,singout);
		singout.isDisplayed();
		log.info("############### signout is displayed ###################");
		return true;
	}catch(Exception e){
		return false;
	}

}
	public void clickLogout() throws Exception{
		//waitforElement(300,singout);
		singout.click();
		log.info("############ clicked signout ##############");
		Thread.sleep(10000);
	}
	
	public void clickOnNavigationMenu(String menuname){
		driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/child::li/a[@title='"+menuname+"']")).click();
		log.info("clicked on menuname"+menuname);
	}
	
	public void submenuwomen(String submenuwom){
		driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/child::li/a[@title='Women']/following::ul/li/a[@title='"+submenuwom+"']")).click();
		log.info("Clicked on submenuwom"+submenuwom);
	}
}

