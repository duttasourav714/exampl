package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import baseClasses.BaseClass;

public class Upcoming extends BaseClass {
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	static Actions actions = new Actions(driver);
	
	@FindBy(id="makeId/option[2]")
	public static WebElement honda;
	
	@FindBy(xpath="//*[@id='rhsDiv']/aside/div[4]/ul/li[5]/a")
	public WebElement filter;
	public static void findHonda() { //method to select 'Honda' form 'Select manufacturer'
		Select select= new Select(driver.findElement(By.id("makeId"))); //clicking select manufacturer, a drop-down appears
		select.selectByVisibleText("Honda"); //clicking 'Honda' from the drop down

	}
	

}
