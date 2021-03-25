package testCases;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utilities.ExtentReportManager;

import baseClasses.BaseClass;
import pageClasses.clickLogin;
import utilities.takeSS;

public class Login extends BaseClass {
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	@Test(groups= {"testCase"}) //testcase to login using google-id
	public void login()
	{
		invokeBrowser(); //to invoke the browser
		logger = report.createTest("zigWheels");
		logger.log(Status.INFO,"*******Starting with Browser Set Up*********");
		openApplication(); //to get to the website
		logger.log(Status.INFO,"opened website");
		try {
			clickLogin.login(); //method the click the Login
			takeSS.captureScreenShot(driver, "loginSS"); //to take screenshot with the name 'loginSS'
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.log(Status.PASS, "Logged in succesfull");
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
