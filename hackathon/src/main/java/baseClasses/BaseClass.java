package baseClasses;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import pageClasses.Landingpage;


public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public String url;
	String browser;

	public void invokeBrowser() {   //method to invoke the browser
		
		
		Properties prop= new Properties();
		try {
			InputStream input= new FileInputStream("./configure.properties"); //to get data from properties file
			prop.load(input); 
			url=prop.getProperty("url"); //getting the url from properties file
			browser=prop.getProperty("browse");
			System.out.println(browser);
		} catch (Exception e) { //if any exception occurs
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger = Logger.getLogger(BaseClass.class);
		/*PropertyConfigurator.configure(
				"./src/main/resources/Log4j2Properties/log4j.properties");
		PropertyConfigurator.configure("user.dir"+"log4j.properties");*/

		logger.info("*******Starting with Browser Set Up*********");
		
		
		System.out.println("url::::::" + url);

		/*switch (browser) {

		case "chrome":*/
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver(); //setting the driver to invoke Chrome Browser
			//break;
		/*case "firefox":
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info(String.format("Identified the browser as %s. Launching the browser", browser));
			break;

		case "ie":
			//WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			logger.info(String.format("Identified the browser as %s. Launching the browser", browser));
			break;
		case "headlessbrowser":
			//WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			WebDriver driver = new ChromeDriver(options);

		default:
			logger.info(String.format("Could not identify the browser as %s. Please specify correct browser", browser));
			break;
		}*/
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//logger.info("Launched the cucumber Application");
	}
	

	public void openApplication() {
		driver.get(url); //opening the website of ZigWheels
		driver.manage().window().maximize(); //Maximizing the browser
		driver.manage().deleteAllCookies();
	}



}
