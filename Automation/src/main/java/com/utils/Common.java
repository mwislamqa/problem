package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.com.Base;



public class Common extends Base{

	
	public static void takeScreenshot() throws IOException {
		 TakesScreenshot sc=(TakesScreenshot)driver; 
		  File src =sc.getScreenshotAs(OutputType.FILE); 
		  String currentDir= System.getProperty("user.dir");
		  
		 // File destFile = new File(".\\target\\pic.png");
		  FileUtils.copyFile(src, new File(currentDir +"/screenshots/"+ System.currentTimeMillis()+".png"));
		  //currentDir +"/screenshots/"+ System.currentTimeMillis()+".png"
		  
		//  FileUtils.copyFile(src, currentDir);
	}
}
