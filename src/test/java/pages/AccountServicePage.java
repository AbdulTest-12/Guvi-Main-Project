package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class AccountServicePage extends ProjectSpecificationMethod {
	
	@FindBy(linkText = "Open New Account")
	WebElement OpenNewAccount;
	
	@FindBy(linkText = "Accounts Overview")
	WebElement AccountsOverview;
	
	@FindBy(linkText = "Transfer Funds")
	WebElement TransferFunds;
	
	@FindBy(linkText = "Bill Pay")
	WebElement BillPay;
	
	@FindBy(linkText = "Find Transactions")
	WebElement FindTransactions;
	
	@FindBy(linkText = "Update Contact Info")
	WebElement UpdateContactInfo;
	
	@FindBy(xpath  = "//a[normalize-space()='Request Loan']")
	WebElement RequestLoan;
	
	@FindBy(linkText = "Log Out")
	WebElement LogOut;
	
	@SuppressWarnings("static-access")
	public  AccountServicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OpenNewAccountPage NewAccount() {
		OpenNewAccount.click();
		return new OpenNewAccountPage(driver);
	}
	
	public void AccountsOverview() {
		AccountsOverview.click();
		
	}
	
	public TransferFundsPage TransferFunds() {
		TransferFunds.click();
		return new TransferFundsPage(driver);
	}
	
	public BillPayPage BillPay() {
		BillPay.click();
		return new BillPayPage(driver);
	}
	
	public FindTransactionsPage FindTransactions() {
		FindTransactions.click();
		return new FindTransactionsPage(driver);
	}
	
	public UpdateContactInfo UpdateContact() {
		UpdateContactInfo.click();
		return new UpdateContactInfo(driver);
	}
	public RequestLoanPage RequestLoan() {
		RequestLoan.click();
		return new RequestLoanPage(driver);
	}
	
	public HomePage Logout() {
		LogOut.click();
		return new HomePage(driver);
	}
}
