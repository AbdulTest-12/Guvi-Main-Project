package tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.AccountServicePage;
import pages.HomePage;
import pages.RequestLoanPage;
public class RequestLoanModule extends ProjectSpecificationMethod{

	@BeforeTest
	public void setup() throws IOException {
		
		sheetname = "Loan";
		testName = "Request Loan Test";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of Request Loan Functionality";
	}
	@Test(dataProvider = "readData")
	public  void RequestLoan(String username, String password, String loanAmount, 
			String downPayment, String index, String testType, String expectedMessage) {
		HomePage login = new HomePage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.ClickLoginBtn();

	
		AccountServicePage loan = new AccountServicePage(driver);
		loan.RequestLoan();
		
		RequestLoanPage details = new RequestLoanPage(driver);
		details.enterLoamAmount(loanAmount);
		details.enterDowenPayment(downPayment);
		details.FromAccount(index);
		details.ClickApply();
	}

}
