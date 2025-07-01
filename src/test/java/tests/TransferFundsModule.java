package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.AccountServicePage;
import pages.HomePage;
import pages.TransferFundsPage;

public class TransferFundsModule extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		sheetname ="Transfer";
		testName = "Transfer FundsTest";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of Transfer Funds Functionality";
	}
	
	@Test(dataProvider = "readData")
	public void TransferFunds(String username, String password, String amount, String fromAccountindex, String toAccountindex, 
		String testType, String expectedMessage) throws InterruptedException {
		HomePage login = new HomePage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.ClickLoginBtn();
		
		AccountServicePage transferfund = new AccountServicePage(driver);
		transferfund.TransferFunds();
		
		TransferFundsPage details = new TransferFundsPage(driver);
		details.enterAmount(amount);
		details.FromAccountNo(fromAccountindex);
		details.ToAccountNo(toAccountindex);
		details.ClickTransfer();
		Thread.sleep(1500);
		details.validateTransferFunds(testType, expectedMessage);
		

	}

}
