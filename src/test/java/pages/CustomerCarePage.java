package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class CustomerCarePage extends ProjectSpecificationMethod{

	@FindBy(xpath  = "//input[@id='name']")
	WebElement Name;

	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement PhnNum;

	@FindBy(xpath = "//textarea[@id='message']")
	WebElement Message;

	@FindBy(xpath = "//input[@value='Send to Customer Care']")
	WebElement CustomerCareBtn;

	@FindBy(xpath = "//p[contains(text(),'A Customer Care Representative will be contacting ')]")
	WebElement CustomerCareReachyou;

	@FindBy(id = "name.errors")
	WebElement NameError;

	@FindBy(id = "email.errors")
	WebElement EmailError;

	@FindBy(id = "phone.errors")
	WebElement PhnError;

	@FindBy(id = "message.errors")
	WebElement MsgError;

	@SuppressWarnings("static-access")
	public CustomerCarePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CustomerCarePage enterName(String name) {
		Name.clear();
		Name.sendKeys(name);
		return this;
	}

	public CustomerCarePage enterEmail(String email) {
		Email.clear();
		Email.sendKeys(email);
		return this;
	}


	public CustomerCarePage enterPhnNum(String phnnum) {
		PhnNum.clear();
		PhnNum.sendKeys(phnnum);
		return this;
	}

	public CustomerCarePage enterMessageBtn(String msg) {
		Message.sendKeys(msg);
		return this;
	}

	public AccountServicePage ClickCustomercareBtn() {
		CustomerCareBtn.click();
		return new AccountServicePage(driver);
	}

	public HomePage CustomerCareReachYou() {
		CustomerCareReachyou.getText();
		return new HomePage(driver);
	}

	public CustomerCarePage NameError() {
		NameError.getText();
		return this;
	}

	public CustomerCarePage EmailError() {
		EmailError.getText();
		return this;
	}

	public CustomerCarePage PhnError() {
		PhnError.getText();
		return this;
	}

	public CustomerCarePage MsgError() {
		MsgError.getText();
		return this;
	}

	public void validateCustomerCareform(String testType, String expectedMessage) {

		if(testType.equals("valid")) {

			String actualText = CustomerCareReachyou.getText();
			Assert.assertEquals(actualText, expectedMessage);

		}else if(testType.equals("missing name")) {

			String actualText = NameError.getText();
			Assert.assertEquals(actualText, expectedMessage);
			
		}else if(testType.equals("missing email")) {
			
			String actualText = EmailError.getText();
			Assert.assertEquals(actualText, expectedMessage);

	}else if(testType.equals("missing phn")) {
			
			String actualText = PhnError.getText();
			Assert.assertEquals(actualText, expectedMessage); 
	}
	else if(testType.equals("missing msg")) {
		
		String actualText = MsgError.getText();
		Assert.assertEquals(actualText, expectedMessage);

	}
}
}
