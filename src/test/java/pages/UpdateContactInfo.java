package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

class UpdateContactInfo extends ProjectSpecificationMethod {
	
	@FindBy(xpath = "//input[@id='customer.firstName']")
	WebElement UpdateFirstName;
	
	@FindBy(xpath = "//input[@id='customer.lastName']")
	WebElement UpdateLastName;
	
	@FindBy(xpath = "//input[@id='customer.address.street']")
	WebElement UpdateAddress;
	
	@FindBy(xpath = "//input[@id='customer.address.city']")
	WebElement UpdateCity;
	
	@FindBy(xpath = "//input[@id='customer.address.state']")
	WebElement UpdateState;
	
	@FindBy(xpath = "//input[@id='customer.address.zipCode']")
	WebElement UpdateZipcode;
	
	@FindBy(xpath = "//input[@id='customer.phoneNumber']")
	WebElement UpdatePhnNum;
	
	@FindBy(xpath = "//input[@value='Update Profile']")
	WebElement  UpdateProfile;
	
	@SuppressWarnings("static-access")
	public UpdateContactInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public UpdateContactInfo UpdateFirstName(String updatefname) {
		UpdateFirstName.sendKeys(updatefname);
		return this;
	}
	
	public UpdateContactInfo UpdateLastName(String updatelname) {
		UpdateLastName.sendKeys(updatelname);
		return this;
	}
	
	public UpdateContactInfo UpdateAddress(String updateaddress) {
		UpdateAddress.sendKeys(updateaddress);
		return this;
	}
	
	public UpdateContactInfo UpdateCity(String updatecity) {
		UpdateCity.sendKeys(updatecity);
		return this;
	}
	
	public UpdateContactInfo UpdateState(String updatestate) {
		UpdateState.sendKeys(updatestate);
		return this;
	}
	
	public UpdateContactInfo UpdateZipcode(String updatezipcode) {
		UpdateZipcode.sendKeys(updatezipcode);
		return this;
	}
	
	public UpdateContactInfo UpdatePhnNum(String updatephnnum) {
		UpdatePhnNum.sendKeys(updatephnnum);
		return this;
	}
	
	public AccountServicePage UpdateFirstName() {
		UpdateProfile.click();
		return new AccountServicePage(driver);
	}
}

