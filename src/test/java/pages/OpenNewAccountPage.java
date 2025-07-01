package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificationMethod;

public class OpenNewAccountPage extends ProjectSpecificationMethod{
	
	@FindBy(xpath = "//select[@id='type']")
	WebElement AccountType;
	
	@FindBy(xpath = "//select[@id='fromAccountId']")
	WebElement FromAccount;
	
	@FindBy(xpath = "//input[@value='Open New Account']")
	WebElement OpenNewAcct;
	
	@FindBy(id = "newAccountId")
	WebElement NewAcctID;
	
	@SuppressWarnings("static-access")
	public OpenNewAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OpenNewAccountPage SelectAccountType() {
		AccountType.click();
		return this;
	}
	
	public OpenNewAccountPage  SelectAccount(String Cindex) {
		 Select accountDropdown = new Select(FromAccount); 
		    accountDropdown.selectByIndex(0); 
		    return this;
	}
	
	public OpenNewAccountPage  SelectsavingAccount(String Sindex) {
		 Select accountDropdown = new Select(FromAccount); 
		    accountDropdown.selectByIndex(1); 
		    return this;
	}
	
	public AccountServicePage ClickOpenNewAcct() {
		OpenNewAcct.click();
		return new AccountServicePage(driver);
	}
	
	public void ClickNewAcctID() {
		NewAcctID.click();
	}
	
	public static boolean isAcctDetailsDisplayed() {
        return driver.findElement(By.id("accountDetails")).isDisplayed();
    }
	
	public boolean isAcctIDDisplayed() {
        return driver.findElement(By.xpath("//td[normalize-space()='Account Number:']")).isDisplayed();
    }
	public static boolean isBalanceDisplayed() {
        return driver.findElement(By.xpath("//td[normalize-space()='Balance:']")).isDisplayed();
    }
	
	public boolean isAcctTypeDisplayed() {
        return driver.findElement(By.xpath("//td[normalize-space()='Account Type:']")).isDisplayed();
    }
	
	public boolean isAvlBalanceDisplayed() {
        return driver.findElement(By.xpath("//td[normalize-space()='Available:']")).isDisplayed();
    }
	
}

	    
