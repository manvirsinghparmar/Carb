package com.carbonite.qa.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carbonite.qa.base.TestBase;

public class CompareBackUpPlanPage extends TestBase {
	
	
	@FindBy(css="div>button")
	public
	WebElement buynow;

	public CompareBackUpPlanPage() {
		PageFactory.initElements(driver, this);
	}

	public String getTitleOfThePage() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String titleOfThePage = driver.getTitle();

		return titleOfThePage;
	}
	

}
