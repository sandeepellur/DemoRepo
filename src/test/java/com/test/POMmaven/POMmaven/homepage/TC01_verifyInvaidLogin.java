/**
 * 
 */
package com.test.POMmaven.POMmaven.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.POMmaven.POMmaven.Actions.HomePage;
import com.test.POMmaven.POMmaven.TestBase.TestBase;

/**
 * @author Sandeep
 *
 */
public class TC01_verifyInvaidLogin extends TestBase {
	
	public static final Logger log= Logger.getLogger(TC01_verifyInvaidLogin.class.getName());
	
	@BeforeTest
	public void setup(){
		init();
		
	}
	
	@Test
	public void verifybyinvlidlogin() {
		log.info("######### Starting verifybyinvlidlogin test ###########");
		HomePage homepage=new HomePage(driver);
		homepage.loginToApplication("test@gmail.com", "password");	
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/div[1]/ol/li")).getText(), "Authentication failed.");
		log.info("Error Message validation Passed");
		log.info("######### ending verifybyinvlidlogin test ###########");
	}
	
	@AfterTest
	public void endTest(){
		
		driver.close();
	}
}
