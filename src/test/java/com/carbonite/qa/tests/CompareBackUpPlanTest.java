package com.carbonite.qa.tests;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	WebDriverWait wait;

	@BeforeMethod
	void setUp() {

		initialisation();

		signUpPage = new SignUpPage();

		backUpPlan = signUpPage.ClickOnCompareBackUpPlanPage();

		wait=new WebDriverWait(driver, 15);
	}

	// Verify the title of the page upon navigation
	@Test(priority = 1,enabled = true)
	void getTitleOfThePage() {

	
		wait.until(ExpectedConditions.visibilityOf(backUpPlan.buynow));
		
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
