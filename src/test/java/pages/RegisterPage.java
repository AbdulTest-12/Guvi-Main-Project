package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class RegisterPage extends ProjectSpecificationMethod {
	
	@FindBy(id = "customer.firstName")
	WebElement firstName;
	
	@FindBy(id = "customer.lastName")
	WebElement lastName;
	
	@FindBy(id = "customer.address.street")
	WebElement address;
	
	@FindBy(id = "customer.address.city")
	WebElement city;
	
	@FindBy(id = "customer.address.state")
	WebElement state;
	
	@FindBy(id = "customer.address.statecustomer.address.state")
	WebElement zipcode;
	
	@FindBy(id = "customer.phoneNumber")
	WebElement phone;
	
	@FindBy(id = "customer.ssn")
	WebElement SSN;
	
	@FindBy(id = "customer.username")
	WebElement UserName;
	
	@FindBy(id = "customer.password")
	WebElement Password;
	
	@FindBy(id = "repeatedPassword")
	WebElement CnfmPassword;
	
	@FindBy(xpath =  "//input[@value='Register']")
	WebElement Register;
	
	@FindBy(xpath = "//p[@class='error']")
	WebElement ErrorMsg;
	
	@SuppressWarnings("static-access")
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public RegisterPage enterFirstName(String Firstname) {
		firstName.clear();
		firstName.sendKeys(Firstname);
		return this;
	}
	
	public RegisterPage enterLastName(String Lastname) {
		lastName.clear();
		lastName.sendKeys(Lastname);
		return this;
	}

	public RegisterPage enterAddress(String Address) {
		address.clear();
		address.sendKeys(Address);
		return this;
	}
	
	public RegisterPage enterCity(String City) {
		city.clear();
		city.sendKeys(City);
		return this;
	}
	
	public RegisterPage enterState(String State) {
		state.clear();
		state.sendKeys(State);
		return this;
	}
	
	public RegisterPage enterZipCode(String ZipCode) {
		zipcode.clear();
		zipcode.sendKeys(ZipCode);
		return this;
	}
	
	public RegisterPage enterPhnoneNumber(String PhnNUm) {
		phone.clear();
		phone.sendKeys(PhnNUm);
		return this;
	}
	
	public RegisterPage enterSSN(String ssn) {
		SSN.clear();
		SSN.sendKeys(ssn);
		return this;
	}
	
	public RegisterPage enterUserName(String username) {
		UserName.clear();
		UserName.sendKeys(username);
		return this;
	}
	
	public RegisterPage enterPassword(String psw) {
		Password.clear();
		Password.sendKeys(psw);
		return this;
	}
	
	public RegisterPage enterCnfmPassword(String cnfmpsw) {
		CnfmPassword.clear();
		CnfmPassword.sendKeys(cnfmpsw);
		return this;
	}
	
	public AccountServicePage ClickRegister() {
		Register.click();
		return new AccountServicePage(driver);
	}
	
	public static String getErrorMsg() {
		return driver.findElement(By.xpath("ErrorMsg")).getText();
	}
	
}
