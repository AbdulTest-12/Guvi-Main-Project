package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod {
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement LoginUserName;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement LoginPassword;
	
	@FindBy(xpath = "//input[@value='Log In']")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//b[normalize-space()='Welcome']")
	WebElement Welcome;
	
	@FindBy(xpath = "//p[contains(text(),'Your account was created successfully. You are now')]")
	WebElement AccountCreated;
	
	@FindBy(linkText  = "Forgot login info?")
	WebElement ForgotLoginInfo;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement RegisterBtn;
	
	@FindBy(linkText = "Contact Us")
	WebElement ContactUs;
	
	@FindBy(xpath = "//a[normalize-space()='about']")
	WebElement AboutIcon;
	
	@FindBy(xpath = "//a[normalize-space()='home']")
	WebElement HomeIcon;
	
	@FindBy(xpath = "//h2[normalize-space()='Account Services']")
	WebElement AccountService;
	
	@FindBy(xpath = "//p[@class='error']")
	WebElement ErrorMsg;
	
	@FindBy(xpath = "//p[text()='The username and password could not be verified.']")
	WebElement NoUser;
	
	@SuppressWarnings("static-access")
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public HomePage enterUserName(String username) {
		LoginUserName.clear();
		LoginUserName.sendKeys(username);
		return this;
	}
	
	public HomePage enterPassword(String psw) {
		
		LoginPassword.sendKeys(psw);
		return this;
	}
	
	public AccountServicePage ClickLoginBtn() {
		LoginBtn.click();
		return new AccountServicePage(driver);
	}
	
	public AccountServicePage AccountCreated() {
		 AccountCreated.getText();
		return new AccountServicePage(driver);
	}
	
	public RegisterPage ClickRegister() {
		RegisterBtn.click();
		return new RegisterPage(driver);
	}
	
	public CustomerCarePage ClickContact() {
		ContactUs.click();
		return new CustomerCarePage(driver);
	}
	
	
	  public String getPasswordFieldType() {
	        return driver.findElement(By.xpath("//input[@name='password']")).getAttribute("type");
	    }
	
	
	public void validateLogin(String testType, String expectedMessage) {
		
		if(testType.equals("Valid")) {
			
			String actualText = AccountService.getText();
			Assert.assertEquals(actualText, expectedMessage);
					
			}else if(testType.equals("Invalid Password")) {
					
				String actualText = NoUser.getText();
				Assert.assertEquals(actualText, expectedMessage);
				
				}else if(testType.equals("Nodata")) {
					
				String actualText = ErrorMsg.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}else if(testType.equals("Not Registered")) {
					
				String actualText = NoUser.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}
		
	}

}
