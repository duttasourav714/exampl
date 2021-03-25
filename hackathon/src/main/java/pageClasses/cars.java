package pageClasses;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClasses.BaseClass;
import utilities.writeExcelFile;

public class cars extends BaseClass{
	static ArrayList<String> arr= new ArrayList<String>();
	static JavascriptExecutor js = (JavascriptExecutor) driver;

	public static void getCars() //method to get all the car names in Chennai
	{//it is observed that the xpaths of car names are almost similar except for a numeric value, so the for loop
		for(int i=1; i<12; i+=2)
		{
			WebElement e= driver.findElement(By.xpath("//*[@id=\'data-set-body\']/div["+i+"]/div[1]/div[3]/div[2]/a"));
			js.executeScript("arguments[0].scrollIntoView();", e); //to scroll the web page
			arr.add(e.getText()); //adding the names from webpage to ArrayList arr
			writeExcelFile.writeExcel(arr); //writing the names in excel file
		}
	}
	public static void showCars() //method to iterate the arr and show output in console
	{
		System.out.println("The popular used cars in Chennai are: ");
		for (int i = 0; i < arr.size(); i++) 
            System.out.println(arr.get(i) + " "); 
    } 

	
}
/*
 //*[@id="data-set-body"]/div[1]/div[1]/div[3]/div[2]/a
//*[@id="data-set-body"]/div[3]/div[1]/div[3]/div[2]/a
//*[@id="data-set-body"]/div[5]/div[1]/div[3]/div[2]/a
//*[@id="data-set-body"]/div[7]/div[1]/div[3]/div[2]/a
//*[@id="data-set-body"]/div[9]/div[1]/div[3]/div[2]/a
//*[@id="data-set-body"]/div[11]/div[1]/div[3]/div[2]/a
 */
