package pageClasses;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


import baseClasses.BaseClass;

public class clickLogin extends BaseClass {
	static Actions actions = new Actions(driver);
	public static void login() throws InterruptedException
	{
		driver.findElement(By.id("forum_login_title_lg")).click(); //clicking the login button
		Thread.sleep(5000);
		driver.findElement(By.id("googleSignIn")).click(); //clicking the 'Continue with Google'
		//a new window pops up, to handle this we used the getWindowHandles()
		Set<String> handle=driver.getWindowHandles();
		Iterator itr= handle.iterator();
		String mainWindow=(String) itr.next(); //stores the main window
		String childWindow= (String) itr.next(); //stores the child window
		driver.switchTo().window(childWindow); //switching to the child window
		driver.findElement(By.xpath("//*[@id=\'identifierId\']")).sendKeys("ssss!%^47(s"); //giving irrelevant values in the e-mail id field
		driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/div[2]")).click(); //clicking continue
		Thread.sleep(2000); 
		String a=driver.findElement(By.xpath("//*[@id=\'view_container\']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")).getText(); //getting the error message
		System.out.println(a); //printing the error messahe in console

	}
	
}

