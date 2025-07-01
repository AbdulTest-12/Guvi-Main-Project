package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class BillPayPage extends ProjectSpecificationMethod {
	
	@FindBy(xpath  = "//input[@name='payee.name']")
	WebElement PayeeName;
	
	@FindBy(xpath = "//input[@name='payee.address.street']")
	WebElement Address;
	
	@FindBy(xpath = "//input[@name='payee.address.city']")
	WebElement City;
	
	@FindBy(xpath = "//input[@name='payee.address.state']")
	WebElement State;
	
	@FindBy(xpath = "//input[@name='payee.address.zipCode']")
	WebElement Zipcode;
	
	@FindBy(xpath = "//input[@name='payee.phoneNumber']")
	WebElement PhnNum;
	
	@FindBy(xpath = "//input[@name='payee.accountNumber']")
	WebElement AccountNum;
	
	@FindBy(xpath = "//input[@name='verifyAccount']")
	WebElement VerifyAccountNum;
	
	@FindBy(xpath = "//input[@name='amount']")
	WebElement Amount;
	
	@FindBy(xpath = "//select[@name='fromAccountId']")
	WebElement FromAccount;
	
	@FindBy(xpath = "//input[@value='Send Payment']")
	WebElement SendPayment;
	
	@SuppressWarnings("static-access")
	public BillPayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public BillPayPage enterPayeeName(String payeeName) {
		PayeeName.sendKeys(payeeName);
		return this;
	}
	
	public BillPayPage enterAddress(String address) {
		Address.sendKeys(address);
		return this;
	}

	public BillPayPage enterCity(String city) {
		City.sendKeys(city);
		return this;
	}
	
	public BillPayPage enterState(String state) {
		State.sendKeys(state);
	    return this; 
	}
	
	public BillPayPage enterZipcode(String zipcode) {
		
		Zipcode.sendKeys(zipcode);
		return this;
	}
	
	public BillPayPage enterPhnMNum(String phnnum) {
		PhnNum.sendKeys(phnnum);
		return this;
	}
	
	public BillPayPage enterAccountNum(String accountNum) {
		AccountNum.sendKeys(accountNum);
		return this;
	}
	
	public BillPayPage VerifyAcctNum(String verifyAcct) {
		VerifyAccountNum.sendKeys(verifyAcct);
		return this;
	}
	
	public BillPayPage enterAmount(String amount) {
		Amount.sendKeys(amount);
		return this;
	}
	
	public BillPayPage FromAccount() {
		FromAccount.click();
		return this;
	}
	
	public void ClickSendPayment() {
		SendPayment.click();
		
	}
} 
