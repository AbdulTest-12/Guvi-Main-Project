package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.NavigationPage;

public class NavigationTestModule extends ProjectSpecificationMethod{

	@BeforeTest
	public void setup() {
		testName = "Navigation Test";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of Nav Functionality";

	}
	@Test(priority = 1)
	public  void NavigationTest() {

		NavigationPage navPage = new NavigationPage(driver);
		navPage.goToHome();
		Assert.assertTrue(driver.getTitle().contains("ParaBank | Welcome | Online Banking"));
	}

	@Test(priority = 2)
	public void ActionButtonsVisibility() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Log In']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Register']")).isDisplayed());

		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='home']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='about']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='contact']")).isDisplayed());

	}
	@Test(priority = 3)
	public void FontConsistency() throws InterruptedException {
		
		 WebElement header = driver.findElement(By.xpath("//img[@title='ParaBank']"));
		    header.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement freshHeader = wait.until(ExpectedConditions.presenceOfElementLocated(
		    By.xpath("//img[@title='ParaBank']")));
		
		String fontFamily = freshHeader.getCssValue("fontFamily");

	    Assert.assertTrue(fontFamily.contains("Arial") || fontFamily.contains("Helvetica") || fontFamily.contains("sans-serif"));
	        
	    }

}
