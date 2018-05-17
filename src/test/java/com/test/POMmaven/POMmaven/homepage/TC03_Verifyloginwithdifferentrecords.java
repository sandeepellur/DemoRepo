package com.test.POMmaven.POMmaven.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.POMmaven.POMmaven.Actions.HomePage;
import com.test.POMmaven.POMmaven.TestBase.TestBase;

public class TC03_Verifyloginwithdifferentrecords extends TestBase{
	
public static final Logger log= Logger.getLogger(TC03_Verifyloginwithdifferentrecords.class.getName());

    
    @DataProvider(name="logindata")
    public String[][] getTestData(){
    	String[][] data =getData("testingdata.xlsx", "data");    	
    	return data;
    }
    
	@BeforeClass
	public void setup(){
		init();		
	}

	@Test(dataProvider="logindata")
	public void testlogin(String Userid, String Passwd,String runMode) throws Exception{
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("User marked this record as N");
		}
		log.info("################## Stating Verifyloginwithdifferentrecords case ##################");	
		HomePage homepage=new HomePage(driver);
		homepage.loginToApplication(Userid, Passwd);
		boolean status = homepage.verifyloginmessage();
		getScreenshot("testlogin"+Userid);
		if(status){
			homepage.clickLogout();
		}
		Assert.assertEquals(status, true);
		
		log.info("################## End Verifyloginwithdifferentrecords case ##################");
				
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
		
	}
}
