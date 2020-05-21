package org.flipLearn.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class FlipLearnTest extends BaseClass{

	@Test
	public void loginTest() throws Exception {
		
		//Verify that user is on correct page
		String pageTitle = driver.getTitle();
		System.out.println("Page title is = " + pageTitle);
		Assert.assertTrue(pageTitle.equals("Fliplearn"), "User is not on correct page.");
		System.out.println("User is on Fliplearn page.");
		
		//Click on User ID/Password button
		WebElement loginbtn = driver.findElement(By.xpath("//button[@class='themeOutlineButton padding-10-60 mobilebtnBlock mobilemargin0']"));
		loginbtn.click();
		
		//Enter User ID
			WebElement username = driver.findElement(By.xpath("//input[@id='Fname']"));
			username.sendKeys("8800229228");
			
		//Enter Password
			
			WebElement password = driver.findElement(By.xpath("//input[@id='password-lg1']"));
			password.sendKeys("hitesh");
		
		//Click on login button
		WebElement login = driver.findElement(By.xpath("//button[@class='themeButtonFliplearn padding-10-60 mobilebtnBlock mobilemargin0']"));
		login.click();
		
		System.out.println("Click on login button.");
		
		
		//Enter learner profile details
		try {
			//Enter Learner's Name
			WebElement LearnerName = driver.findElement(By.cssSelector("#learnersName"));
			LearnerName.sendKeys("Hitesh Khanna");
			
		}
		catch(Exception ex) {
			System.out.println("Learner's Profile section not present on Page. " + ex.toString());
		}
		
		//Select Class
		WebElement LearnerClass = driver.findElement(By.xpath("//select[@id='selectTerm2']"));
		Select selectClass = new Select(LearnerClass);
		selectClass.selectByVisibleText("Class 11");
		
		//Select the slider option
		WebElement slideroptn = driver.findElement(By.xpath("//span[@id='learnPracticeModeSwitch']"));
		slideroptn.click();
		//Click on Mathematics
		WebElement mathematics = driver.findElement(By.xpath("//div[@class='col-sm-12 m-t-20 ng-scope']//div[@class='owl-stage']//div[1]//div[1]//a[1]//img[1]"));
		mathematics.click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div[class*='otherAstronaut'] img")).getAttribute("src").contains("math"), "Mathematics page is not open.");
		System.out.println("Mathematics page is open.");
		driver.navigate().back();
		
		//Click on My Performance dashboard
		WebElement dasboard = driver.findElement(By.xpath("//a[@class='dashBoardButton text-color-purple ng-scope']"));
		dasboard.click();
		System.out.println("Performance dashboard page is open.");
		driver.close();
	
		
	}
}
