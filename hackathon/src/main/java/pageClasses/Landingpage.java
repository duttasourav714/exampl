package pageClasses;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import baseClasses.BaseClass;


public class Landingpage extends BaseClass {
	
	static Actions actions = new Actions(driver);
	
	public static void clickNewBikes()
	{
		WebElement new_bikes=driver.findElement(By.linkText("New Bikes"));
		actions.moveToElement(new_bikes).perform(); //hover-over the 'New Bikes' to get the drop-down menu

		WebElement e=driver.findElement(By.xpath("//*[@id=\'headerNewNavWrap\']/div[2]/ul/li[3]/ul/li/div[1]/ul/li[3]/span"));
		actions.moveToElement(e).click().perform(); //clicking 'upcoming bikes' from the drop-down

	}

	
}
