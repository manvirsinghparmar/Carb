package com.carbonite.qa.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carbonite.qa.base.TestBase;

public class AllProductsPage extends TestBase {
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	public AllProductsPage() {

		PageFactory.initElements(driver, this);
	}


	@FindBy(css="")
	WebElement learnMoreButton;

	public String getTitleOfThePage() {

		String titleOfThePage = driver.getTitle();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return titleOfThePage;
	}

	public CyberResilience learnMoreClick() {
		
		jse.executeScript("arguments[0].scrollIntoView(true);", learnMoreButton);

		learnMoreButton.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new CyberResilience();
		

	}

}
