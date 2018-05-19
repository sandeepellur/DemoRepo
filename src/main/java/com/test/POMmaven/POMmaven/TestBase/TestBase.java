package com.test.POMmaven.POMmaven.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.POMmaven.POMmaven.CustomListeners.Listeners;
import com.test.POMmaven.POMmaven.Excelreader.Excel_Reader;
import org.apache.commons.io.FileUtils;

public class TestBase {
	
	public static final Logger log= Logger.getLogger(TestBase.class.getName());
	
	public static WebDriver driver;
	String url="http://automationpractice.com/index.php";
	String browser="chrome";
	Excel_Reader excel;
	Listeners lis;
	public void init(){
		selectbrowser(browser);
		//lis=new Listeners(driver);
		geturl(url);
		String log4confprop="log4j.properties";
		PropertyConfigurator.configure(log4confprop);
		
	}

	
	public void selectbrowser(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sandeep\\workspace\\POMmaven\\drivers\\chromedriver.exe");
			log.info("creating object of "+browser);
			
			driver=new ChromeDriver();
						
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Sandeep\\workspace\\POMmaven\\drivers\\geckodriver.exe");
			log.info("creating object of "+browser);
			driver=new FirefoxDriver();
			
		}
	}
	
	public void geturl(String url){
		driver.get(url);
		log.info("launching the url"+url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public String[][] getData(String excelname,String sheetName){
		String path="C:\\Users\\Sandeep\\workspace\\POMmaven\\src\\main\\java\\com\\test\\POMmaven\\POMmaven\\data\\"+excelname;
		excel=new Excel_Reader(path);
		String[][] data = excel.getDataFromsheet(sheetName, excelname);
		return data;
				
	}
	
	public void waitforElement(int timeOutInSeconds,WebElement elemet){
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(elemet));
	}
	
	public void getScreenshot(String name){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\test\\POMmaven\\POMmaven\\screenshots\\";
				File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(scrfile, destFile);
				
				// This will help us to link the screen shot in testNG report
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			} catch (IOException e) {
				e.printStackTrace();
			}

		
			
	}
}
