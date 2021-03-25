package testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageClasses.cars;
import pageClasses.chennai;
import utilities.takeSS;

public class usedCars extends BaseClass{
	chennai ch;
	
	@Test(groups= {"testCase"}) //testcase to get the popular used cars in Chennai
	public void searchUsedCars()
	{
		invokeBrowser(); //to invoke the browser
		openApplication(); //to get to the website
		chennai.clickChennai(); //to get to chennai location
		try {
			takeSS.captureScreenShot(driver, "chennaiCars"); //taking a screenshot with the name 'chennaiCars'
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cars.getCars(); //to get the names of all cars and writing the same in excel file
		cars.showCars(); //to get the output in console
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}

