package Base.com;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties pop;
	FileInputStream file;

	public Base() {

		pop = new Properties();

		try {
			file = new FileInputStream(
					"C:\\EclipseWork space\\batch1\\Automation\\src\\main\\java\\config\\config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			pop.load(file);
			System.out.println("file is loaded");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

// crossBroser testing

	/*
	 * public static void initialize() { setUp(); }
	 */

	/*
	 * public static void setUp() { String browser= {"chrome","ff"};
	 * 
	 * if([]browser.equalsIgnoreCase("Chrome")){
	 * WebDriverManager.chromedriver().setup(); driver= new ChromeDriver(); } else
	 * if(browser.equalsIgnoreCase("Firefox")){
	 * WebDriverManager.firefoxdriver().setup(); driver= new FirefoxDriver(); } }
	 * 
	 * }
	 */

	public static void initialize() {

		String webBrowser = pop.getProperty("browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		if (webBrowser.equalsIgnoreCase(pop.getProperty("chrome"))) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (webBrowser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (webBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get(pop.getProperty("url"));
		driver.manage().window().maximize();

	}

}
