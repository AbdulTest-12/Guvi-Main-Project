package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class TransferFundsPage extends ProjectSpecificationMethod {
	
	@FindBy(xpath = "//input[@id='amount']")
	WebElement Amount;
	
	@FindBy(xpath = "//select[@id='fromAccountId']")
	WebElement FromAccount;
	
	@FindBy(xpath = "//select[@id='toAccountId']")
	WebElement ToAccount;
	
	@FindBy(xpath = "//input[@value='Transfer']")
	WebElement Transfer;
	
	@FindBy(xpath ="//h1[normalize-space()='Transfer Complete!']")
	WebElement TransferCompleted;
	
	@FindBy(xpath = "//p[contains(text(),'An internal error has occurred and has been logged')]")
	WebElement ErrorMsg;
	
	
	@SuppressWarnings("static-access")
	public TransferFundsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public TransferFundsPage enterAmount(String Amt) {
		Amount.clear();
		Amount.sendKeys(Amt);
		return this;
	}
	
	public TransferFundsPage FromAccountNo(String index) {
		 Select accountDropdown = new Select(FromAccount); 
		    accountDropdown.selectByIndex(0); 
		    return this;
	}
	
	public TransferFundsPage ToAccountNo(String index) {
		 Select accountDropdown = new Select(FromAccount); 
		 accountDropdown.selectByIndex(0); 
		    return this;
	}
	
	public void ClickTransfer() {
		Transfer.click();
	}
	
	public void validateTransferFunds(String testType, String expectedMessage) {
		
		if(testType.equals("Valid")) {
			
			String actualText = driver.getPageSource();
			Assert.assertTrue(actualText.contains(expectedMessage), "Expected message not found!");
					
			}else if(testType.equals("Invalid Password")) {
					
				String actualText = ErrorMsg.getText();
				Assert.assertEquals(actualText, expectedMessage);
				
				}else if(testType.equals("Nodata")) {
					
				String actualText = ErrorMsg.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}else if(testType.equals("Invalid Amt")) {
					
				String actualText = ErrorMsg.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}
	}

}
