package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificationMethod;

public class FindTransactionsPage extends ProjectSpecificationMethod{
	
	@FindBy(xpath = "//select[@id='accountId']")
	WebElement SelectAccount;
	
	@FindBy(xpath = "//input[@id='transactionId']")
	WebElement FindByID;
	
	@FindBy(xpath = "//button[@id='findById']")
	WebElement FindByIDBtn;
	
	@FindBy(xpath = "//input[@id='transactionDate']")
	WebElement FindByDate;
	
	@FindBy(xpath = "//button[@id='findByDate']")
	WebElement FindByDateBtn;
	
	@FindBy(xpath = "//input[@id='fromDate']")
	WebElement FindByFromDate;
	
	@FindBy(xpath = "//input[@id='toDate']")
	WebElement FindByToDate;
	
	@FindBy(xpath = "//button[@id='findByDateRange']")
	WebElement FindByDateRangeBtn;
	
	@FindBy(xpath = "//input[@id='amount']")
	WebElement FindByAmt;
	
	@FindBy(xpath = "//button[@id='findByAmount']")
	WebElement FindByAmtBtn;
	
	@SuppressWarnings("static-access")
	public FindTransactionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public FindTransactionsPage SelectAccount(String index) {
		 Select accountDropdown = new Select(SelectAccount); 
		 accountDropdown.selectByIndex(0); 
		 return this;
	}
	
	public FindTransactionsPage FindByID(String ID) {
		 FindByID.sendKeys(ID);
		 return this;
	}
	
	public FindTransactionsPage FindByIDBtn() {
		FindByIDBtn.click();
		return this;
	}
	
	public FindTransactionsPage FindByDate(String date) {
		 FindByDate.sendKeys(date);
		 return this;
	}
	
	public FindTransactionsPage FindByDateBtn() {
		FindByDateBtn.click();
		return this;
	}
	
	public FindTransactionsPage FindByFromDate(String fromdate) {
		  FindByFromDate.sendKeys(fromdate);
		 return this;
	}
	public FindTransactionsPage FindBytoDate(String todate) {
		  FindByToDate.sendKeys(todate);
		 return this;
	}
	public FindTransactionsPage FindByDateRangeBtn() {
		FindByDateRangeBtn.click();
		return this;
	}

	public FindTransactionsPage FindByAmt(String amt) {
		 FindByAmt.sendKeys(amt);
		 return this;
	}
	
	public FindTransactionsPage FindByAmtBtn() {
		FindByAmtBtn.click();
		return this;
	}
	
	public static boolean isTransactionResultsDisplayed() {
        return driver.findElement(By.id("resultContainer")).isDisplayed();
    }
}
