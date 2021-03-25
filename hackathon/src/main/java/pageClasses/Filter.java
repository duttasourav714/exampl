package pageClasses;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClasses.BaseClass;
import utilities.writeProperties;

public class Filter extends BaseClass{
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	static ArrayList<String> list= new ArrayList<String>();
	
	public static void fil() //method to filter the honda bikes below 4 Lakhs
	{
		//it is observed that the xpaths resemble except for one numeric value in between so the for loop
		for(int i=1; i<12;i++)
		{
			if(i==4 || i==8)
				continue;
			else
			{
				WebElement e= driver.findElement(By.xpath("//*[@id=\"carModels\"]/ul/li["+i+"]/div/div[3]/div[1]"));
				js.executeScript("arguments[0].scrollIntoView();", e); //to scroll the web page
				String price=e.getText(); //getting the price of the bikes
				Pattern regex= Pattern.compile("(\\d+(?:\\.\\d+)?)"); //changing the price type from String to float
				Matcher matcher= regex.matcher(price);
				if(matcher.find())
				{
					price= matcher.group();
				}
				float bikePrice=Float.parseFloat(price); //the price is in float
				if(bikePrice<4) //comparing the price to be less than 4
				{
					String s=driver.findElement(By.xpath("//*[@id=\"carModels\"]/ul/li["+i+"]/div/div[3]/a/strong")).getText(); //retrieving the names of bikes of price less than 4
					System.out.println(s);
					list.add(s); //adding the bike details in the Arraylist list
				}
					
			}
		}
		writeProperties.writingfile(list); //Writing the required bike details in 'Honda.properties'
	}
}

/*
 * //*[@id="carModels"]/ul/li[1]/div/div[3]/div[1]  //*[@id="carModels"]/ul/li[1]/div/div[3]/a/strong
 * //*[@id="carModels"]/ul/li[2]/div/div[3]/div[1]  //*[@id="carModels"]/ul/li[2]/div/div[3]/a/strong
 * //*[@id="carModels"]/ul/li[3]/div/div[3]/div[1]  //*[@id="carModels"]/ul/li[3]/div/div[3]/a/strong
 * //*[@id="carModels"]/ul/li[5]/div/div[3]/div[1]  //*[@id="carModels"]/ul/li[5]/div/div[3]/a/strong
 * //*[@id="carModels"]/ul/li[6]/div/div[3]/div[1]
 * //*[@id="carModels"]/ul/li[7]/div/div[3]/div[1]
 * //*[@id="carModels"]/ul/li[9]/div/div[3]/div[1]
 * //*[@id="carModels"]/ul/li[10]/div/div[3]/div[1]
 * //*[@id="carModels"]/ul/li[11]/div/div[3]/div[1]
 * */
