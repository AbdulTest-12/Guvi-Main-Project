package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecificationMethod;

public class RequestLoanStatus extends ProjectSpecificationMethod {
	
	
	@FindBy(xpath = "//p[normalize-space()='Congratulations, your loan has been approved.']")
	WebElement LoanApproved;
	
	@FindBy(xpath = "//p[contains(text(),'We cannot grant a loan in that amount with your av')]")
	WebElement LoanDenied;
	
	@FindBy(xpath = "//p[contains(text(),'You do not have sufficient funds for the given dow')]")
	WebElement InsufficientFund;
	
	@FindBy(xpath = "//p[contains(text(),'An internal error has occurred and has been logged')]")
	WebElement NoLoanDetails;
	
	@SuppressWarnings("static-access")
	public RequestLoanStatus(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public RequestLoanStatus LoanApproved() {
		LoanApproved.getText();
		return this;
	}
	
	public RequestLoanStatus LoanDenied() {
		LoanDenied.getText();
		return this;
	}
	
	public RequestLoanStatus InsufficientFund() {
		InsufficientFund.getText();
		return this;
	}
	
	public RequestLoanStatus NoLoanDeatails() {
		NoLoanDetails.getText();
		return this;

	}
}
