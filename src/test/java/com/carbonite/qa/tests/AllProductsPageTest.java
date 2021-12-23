package com.carbonite.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.webpages.AllProductsPage;
import com.carbonite.qa.webpages.CompareBackUpPlanPage;
import com.carbonite.qa.webpages.SignUpPage;

public class AllProductsPageTest extends TestBase {

	SignUpPage signUpPage;
	AllProductsPage ap;

	@BeforeMethod
	void setUp() {

		initialisation();

		signUpPage = new SignUpPage();

		//ap = signUpPage.ClickOnAllProductsPage();

	}

	@Test(invocationCount = 1)
	void test2() {
		Assert.assertEquals(true, true);
	}

	// Verify the title of the page upon navigation
	@Test(priority = 1, invocationCount = 1, enabled = false)
	void learnMoreClickTest() {

		ap.learnMoreClick();

		Assert.assertEquals(driver.getTitle(), "Cyber Resilience Strategy for Businesses | Carbonite");

	}

	@AfterMethod
	void tearDown() {

		driver.quit();

		logger.info("=====Browser Session End=====");
	}

}
