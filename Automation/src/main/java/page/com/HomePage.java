package page.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.com.Base;

public class HomePage extends Base{


	@FindBy(xpath ="//input[@name='q']" )
	WebElement googleSearch;
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public String logopageTitle() {
		return driver.getTitle();
	}
//test case method
	public Object search() throws IOException {
		googleSearch.sendKeys("selenium");
		googleSearch.sendKeys(Keys.ENTER);
		
		return googleSearch;
		
		 
		 
	
	}
	
	

}
