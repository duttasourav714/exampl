package testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageClasses.Landingpage;
import pageClasses.Upcoming;
import utilities.takeSS;
import pageClasses.Filter;

public class UpcomingBikes extends BaseClass{
	Landingpage lp;
	Upcoming uc;
	Filter fl;

	@Test(groups= {"testCase"}) //testcase to find all upcoming honda bikes below 4 Lakhs
	public void searchUpcomingBikes()
	{
		invokeBrowser(); //to invoke the browser
		openApplication(); //to get to the website
		Landingpage.clickNewBikes(); //clicking new bikes
		try {
			takeSS.captureScreenShot(driver, "hondaBikes"); //taking a screenshot with the name 'hondaBikes'
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Upcoming.findHonda(); //selecting 'Honda' from 'Select Manufacturer'
		
		/*Filter.filter();
		Filter.show();*/
		Filter.fil(); //Filtering the honda bikes below 4 Lakhs
	}
	@AfterTest
	public void close() {
		driver.quit();
	}
}