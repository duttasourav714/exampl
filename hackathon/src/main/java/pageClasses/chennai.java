package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClasses.BaseClass;

public class chennai extends BaseClass{
	static Actions actions = new Actions(driver);
	public static void clickChennai()
	{
		WebElement usedCars=driver.findElement(By.linkText("Used Cars")); //to hover-over the 'Used Cars'
		actions.moveToElement(usedCars).perform();

		WebElement e=driver.findElement(By.xpath("//*[@id=\'headerNewNavWrap\']/div[2]/ul/li[5]/ul/li/div[2]/ul/li[5]/span"));
		actions.moveToElement(e).click().perform(); //to click the 'Chennai'
	}
}
