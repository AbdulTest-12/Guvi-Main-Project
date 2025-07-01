package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.AccountServicePage;
import pages.HomePage;
import pages.OpenNewAccountPage;

public class OpenNewAccountModule extends ProjectSpecificationMethod{

	@BeforeTest
	public void setup() {
 sheetname = "openAcct";
	testName = "Open AcctTest";
	testAuthor = "Abdul Nazeer";
	testCategory = "Regression";
	testCategory = "Validation of Open Acct Functionality";
	}

	@Test(dataProvider = "readData")
	public void AccountDetailsNewAcct(String username, String password, String index) {
		HomePage login = new HomePage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.ClickLoginBtn();


		AccountServicePage newacct = new AccountServicePage(driver);
		newacct.NewAccount();

		OpenNewAccountPage account = new OpenNewAccountPage(driver);
		account.SelectAccount(index);
		account.ClickOpenNewAcct();
		account.ClickNewAcctID();
		Assert.assertTrue(OpenNewAccountPage.isAcctDetailsDisplayed());

	}
}
