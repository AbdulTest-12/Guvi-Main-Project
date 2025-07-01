package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class NavigationPage extends ProjectSpecificationMethod{
	
	@FindBy(linkText = "Home")
    WebElement homeLink;

    @FindBy(linkText = "Accounts Overview")
    WebElement accountsLink;

    @FindBy(linkText = "Transfer Funds")
    WebElement transferLink;

    @FindBy(linkText = "Request Loan")
    WebElement loanLink;

    @FindBy(linkText = "Contact Us")
    WebElement contactLink;
    
    @FindBy(xpath = "//a[normalize-space()='about']")
    WebElement AboutUs;

	
	@SuppressWarnings("static-access")
	public NavigationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public void goToHome() {
        homeLink.click();
    }

    public void goToAccounts() {
        accountsLink.click();
    }

    public void goToTransfer() {
        transferLink.click();
    }

    public void goToLoan() {
        loanLink.click();
    }

    public void goToContact() {
        contactLink.click();
    }


}
