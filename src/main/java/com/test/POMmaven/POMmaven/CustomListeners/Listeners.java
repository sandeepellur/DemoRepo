package com.test.POMmaven.POMmaven.CustomListeners;

import java.util.Calendar;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.POMmaven.POMmaven.TestBase.TestBase;

public class Listeners extends TestBase implements ITestListener{
	/*WebDriver driver;
	public Listeners(WebDriver driver){
		this.driver=driver;
	}
*/
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodname = result.getName();
		if(result.isSuccess()){
			
			 File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 try{
				 String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\test\\POMmaven\\POMmaven\\";
					File destFile = new File((String) reportDirectory+"\\success_screenshots\\"+ methodname + "_" + formater.format(calendar.getTime()) + ".png");
					FileUtils.copyFile(scrfile, destFile);
					
					// This will help us to link the screen shot in testNG report
					Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				 
			 }catch(IOException e){
				 e.printStackTrace();
			 }
			 }
		
	}

	public void onTestFailure(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodname = result.getName();
		if(!result.isSuccess()){
			
			 File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 try{
				 String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\test\\POMmaven\\POMmaven\\";
					File destFile = new File((String) reportDirectory+"\\failuer_screenshots\\"+ methodname + "_" + formater.format(calendar.getTime()) + ".png");
					FileUtils.copyFile(scrfile, destFile);
					
					// This will help us to link the screen shot in testNG report
					Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				 
			 }catch(IOException e){
				 e.printStackTrace();
			 }
			 }
		}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
