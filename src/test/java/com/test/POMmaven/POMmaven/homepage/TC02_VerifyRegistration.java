package com.test.POMmaven.POMmaven.homepage;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.POMmaven.POMmaven.Actions.HomePage;
import com.test.POMmaven.POMmaven.TestBase.TestBase;

public class TC02_VerifyRegistration extends TestBase {
	
	public static final Logger log= Logger.getLogger(TC02_VerifyRegistration.class.getName());
	
	@BeforeTest
	public void setup(){
		init();
		
	}
	
	@Test
	public void verifyregistration() throws Exception {
		
			log.info("=============== STARTING verifyregistration TEST ================");
			HomePage homepage=new HomePage(driver);
			homepage.verifyRegistration();
			//homepage.verifyloginmessage();
			Assert.assertEquals(true, homepage.verifyloginmessage());
		} /*catch (Exception e) {	
			
			e.printStackTrace();
		}*/
	

	@AfterTest
	public void endTest(){
		driver.close();
	}
}
