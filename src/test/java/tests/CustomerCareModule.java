package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.CustomerCarePage;
import pages.HomePage;

public class CustomerCareModule extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		sheetname = "Support";
		testName = "Support Test";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of Support Functionality";
	}
	
	@Test(dataProvider = "readData")
	public  void SupportService(String name, String email, String phone, String message, String testType, String expectedMessage) {
		HomePage home = new HomePage(driver);
		home.ClickContact();
		CustomerCarePage support = new CustomerCarePage(driver);
		support.enterName(name);
		support.enterEmail(email);
		support.enterPhnNum(phone);
		support.enterMessageBtn(message);
		support.ClickCustomercareBtn();
		support.validateCustomerCareform(testType, expectedMessage);
	}

}
