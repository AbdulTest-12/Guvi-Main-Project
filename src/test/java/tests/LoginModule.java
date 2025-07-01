package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class LoginModule extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		sheetname = "Login";
		testName = "LoginTest";
		testAuthor = "Abdul Nazeer";
		testCategory = "Regression";
		testCategory = "Validation of Login Functionality";
	}
    @Test(priority = 1)
	 public void testPasswordFieldIsMasked() {

	        HomePage password = new HomePage(driver);
	        String fieldType = password.getPasswordFieldType();

	        Assert.assertEquals(fieldType, "password", "Password field is not masked.");
	    }
	
	
	@Test(dataProvider = "readData", priority = 2)
	public void LoginTest(String username, String password, String testType, String expectedMessage) {
		HomePage login = new HomePage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.ClickLoginBtn();
		login.validateLogin(testType, expectedMessage);

	}

}
