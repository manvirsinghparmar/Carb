package com.carbonite.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.webpages.CompareBackUpPlanPage;
import com.carbonite.qa.webpages.SignUpPage;

public class CompareBackUpPlanTest extends TestBase {

	SignUpPage signUpPage;
	CompareBackUpPlanPage backUpPlan;

	@BeforeMethod
	void setUp() {

		initialisation();

		signUpPage = new SignUpPage();

		backUpPlan = signUpPage.ClickOnCompareBackUpPlanPage();

	}

	// Verify the title of the page upon navigation
	@Test(priority = 1,enabled = false)
	void getTitleOfThePage() {

	
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String titleOfThePage = backUpPlan.getTitleOfThePage();
		System.out.println(titleOfThePage);

		Assert.assertEquals(titleOfThePage, prop.getProperty("Title-CompareBackUpPlan"));

	}

	@AfterMethod
	void tearDown() {

		driver.quit();
		
		logger.info("=====Browser Session End=====");
	}

}
