 package com.carbonite.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.utils.ExcelUtils;
import com.carbonite.qa.utils.Utils;
import com.carbonite.qa.webpages.SignUpPage;

public class SignUpPageTest extends TestBase {

	SignUpPage signUpPage;

	WebDriverWait wait;
	
	JavascriptExecutor jse;
	
	public static String emailFromUtils=Utils.generateRandomEmail();
	
	public static String passwordFromUtils=Utils.generateRandomPassword();

	@BeforeMethod
	void setUp() throws Exception {

		initialisation();

		signUpPage = new SignUpPage();
		wait = new WebDriverWait(driver, 20);
		
		jse=(JavascriptExecutor) driver;
		
		
		
		
	}

	// Run data driven testing for filling Sign up form using Valid data from Excel
	// sheet
	@Test(priority = 1, dataProvider = "PositiveSignUpDataFromExcelFile",enabled = false)
	public void fillSignUpFormWithValidTestData(String email, String ConfirmEmail, String password,
			String ConfirmPassword) {

		signUpPage.clickCookieDialogBoxCloseButton();

		signUpPage.fillSignUpForm(email, ConfirmEmail, password, ConfirmPassword);

		signUpPage.selectCountryFromDropDown(prop.getProperty("Country"));

		signUpPage.clickOnSubmitButton();
		
		jse.executeScript("return document.readyState");

		//wait.until(ExpectedConditions
				//.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Welcome to Carbonite Safe')]"))));

		Assert.assertEquals(driver.getTitle(), "Download");

	}

	// Run data driven testing for filling Sign up form using InValid data from
	// Excel sheet 
	@Test(priority = 2, enabled = false)
	public void fillSignUpFormWithNegativeTestData(String email, String ConfirmEmail, String password,
			String confirmPassword) {
		
		email=Utils.generateRandomEmail();

		signUpPage.clickCookieDialogBoxCloseButton();

		signUpPage.fillSignUpForm(email, ConfirmEmail, password, confirmPassword);

		if (!email.equalsIgnoreCase(ConfirmEmail)) {

			Assert.assertEquals(signUpPage.emailNotMatchingAlert.getText(), prop.getProperty("EmailMissMatch"));
		}

		if (!password.equalsIgnoreCase(confirmPassword)) {

			Assert.assertEquals(signUpPage.passwordNotMatchingAlert.getText(), prop.getProperty("PasswordMissMatch"));

		}
		
		

	}
	
	
	
	

	//This test case been added to demonstrate the re-run of failed test case
	@Test(priority = 3)
	void test() {
		Assert.assertEquals(true, true);
	}

	@DataProvider(name = "PositiveSignUpDataFromExcelFile")
	String[][] positiveTestDataProvider() throws Exception {

		String filePath = "./TestData\\PositiveTestData.xlsx";

		int row = ExcelUtils.getRowCount(filePath, "Sheet1");
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", 1);

		String[][] SignUpTestData = new String[row][col];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < col; j++) {

				SignUpTestData[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}

		}

		return SignUpTestData;

	}

	@DataProvider(name = "NegativeSignUpDataFromExcelFile")
	String[][] NegativeTestDataProvider() throws Exception {

		String filePath = "./TestData\\NegativeTestData .xlsx";

		int row = ExcelUtils.getRowCount(filePath, "Sheet1");
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", 1);
		
		System.out.println("Row count is : " + row + "......" + "Column Count is : " + col);

		String[][] SignUpTestData = new String[row][col];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < col; j++) {

				SignUpTestData[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}

		}

		return SignUpTestData;

	}

	@AfterMethod
	void tearDown() throws InterruptedException {

		driver.quit();
		logger.info("=====Browser Session End=====");

	}

}
