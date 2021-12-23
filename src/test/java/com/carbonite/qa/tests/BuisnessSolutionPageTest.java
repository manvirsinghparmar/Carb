package com.carbonite.qa.tests;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.webpages.BuisnessSolutionPage;
import com.carbonite.qa.webpages.SignUpPage;

public class BuisnessSolutionPageTest extends TestBase {

	SignUpPage signUpPage;
	BuisnessSolutionPage business;

	@BeforeMethod
	void setUp() {

		initialisation();

		signUpPage = new SignUpPage();

		business = signUpPage.ClickOnBuisnessSolutionPage();

	}

	//Verify the title of the page upon navigation
	@Test(priority = 1,enabled = false)
	void getTitleOfThePage() {

		String titleOfThePage = business.getTitleOfThePage();

		Assert.assertEquals(titleOfThePage, prop.getProperty("Title-BuisnessSolutionPage"));

	}

	@AfterMethod
	void tearDown() {

		driver.quit();
		
		logger.info("=====Browser Session End=====");
	}

}
