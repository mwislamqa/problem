package TestRunner.com;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Base.com.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.com.HomePage;

public class Runner extends Base{
	public HomePage hm;

	
	  Runner(){ 
		  super(); 
		  }
	//@Parameters("Browser") 
	@BeforeTest
	public void setup() {
	new Base();
	initialize();//google.
		
		hm= new HomePage();
		
	}@Test(priority=1)
	public void titelTest() {
		String tt=hm.logopageTitle();
		Assert.assertEquals(tt, "Google");
		
	}
	@Test(priority=2)
	public void input() throws IOException {
		hm.search();
		 TakesScreenshot sc=(TakesScreenshot) driver; 
		  File src =
		  sc.getScreenshotAs(OutputType.FILE); 
		  File destFile = new
		  File(".\\target\\pic.png");
		  FileUtils.copyFile(src, destFile);
		
		 // Assert.assertTrue(true);
	}
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
