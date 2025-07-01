package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.AccountServicePage;
import pages.FindTransactionsPage;
import pages.HomePage;

public class FindTransactionModule extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() throws IOException {
		readAndWritePropFile();
		testName = "Find Transaction Test";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of Find transaction Functionality";
	}
	
	@Test
	public  void FindbyDate() {
		HomePage login = new HomePage(driver);
		login.enterUserName(prop.getProperty("username"))
		.enterPassword(prop.getProperty("password"))
		.ClickLoginBtn();
		
		AccountServicePage service = new AccountServicePage(driver);
		service.FindTransactions();
		
		FindTransactionsPage transaction = new FindTransactionsPage(driver);
		transaction.SelectAccount(prop.getProperty("index"));
		
		
		transaction.FindByDate(prop.getProperty("date"));
		transaction.FindByDateBtn();
		Assert.assertTrue(driver.getPageSource().contains("Transaction Results"));
		
	}
	
	@Test
	public  void FindbyFromandToDate() {
		HomePage login = new HomePage(driver);
		login.enterUserName(prop.getProperty("username"))
		.enterPassword(prop.getProperty("password"))
		.ClickLoginBtn();
		
		AccountServicePage service = new AccountServicePage(driver);
		service.FindTransactions();
		
		FindTransactionsPage transaction = new FindTransactionsPage(driver);
		transaction.SelectAccount(prop.getProperty("index"));

		transaction.FindByFromDate(prop.getProperty("fromdate"));
		transaction.FindBytoDate(prop.getProperty("todate"));
		transaction.FindByDateRangeBtn();
		Assert.assertTrue(driver.getPageSource().contains("Transaction Results"));

	}
	
	@Test
	public  void FindbyAmount() {
		HomePage login = new HomePage(driver);
		login.enterUserName(prop.getProperty("username"))
		.enterPassword(prop.getProperty("password"))
		.ClickLoginBtn();
		AccountServicePage service = new AccountServicePage(driver);
		service.FindTransactions();
		
		FindTransactionsPage transaction = new FindTransactionsPage(driver);
		transaction.SelectAccount(prop.getProperty("index"));
		
		transaction.FindByAmt(prop.getProperty("amount"));
		transaction.FindByAmtBtn();
		Assert.assertTrue(driver.getPageSource().contains("Transaction Results"));

	}
}
