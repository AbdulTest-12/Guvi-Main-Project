package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificationMethod;

public class RequestLoanPage extends ProjectSpecificationMethod {
	
	@FindBy(xpath = "//input[@id='amount']")
	WebElement LoanAmount;
	
	@FindBy(xpath = "//input[@id='downPayment']")
	WebElement DownPayment;
	
	@FindBy(xpath = "//select[@id='fromAccountId']")
	WebElement FromAccount;
	
	@FindBy(xpath = "//input[@value='Apply Now']")
	WebElement ApplyNow;
	
	@FindBy(xpath = "//p[normalize-space()='Congratulations, your loan has been approved.']")
	WebElement LoanApproved;
	
	@FindBy(xpath = "//p[contains(text(),'We cannot grant a loan in that amount with your av')]")
	WebElement LoanDenied;
	
	@FindBy(xpath = "//p[contains(text(),'You do not have sufficient funds for the given dow')]")
	WebElement InsufficientFund;
	
	@FindBy(xpath = "//p[contains(text(),'An internal error has occurred and has been logged')]")
	WebElement NoLoanDetails;
	
	@SuppressWarnings("static-access")
	public RequestLoanPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public RequestLoanPage enterLoamAmount(String loanAmt) {
		LoanAmount.sendKeys(loanAmt);
		return this;
	}
	
	public RequestLoanPage enterDowenPayment(String downpay) {
		DownPayment.sendKeys(downpay);
		return this;
	}
	
	public RequestLoanPage FromAccount(String index) {
	    Select accountDropdown = new Select(FromAccount); 
	    accountDropdown.selectByIndex(0); 
	    return this;
	}
	
	public RequestLoanStatus ClickApply() {
		ApplyNow.click();
		return new RequestLoanStatus(driver);
	}

}
