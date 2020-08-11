
package com.carbonite.qa.RetryFailedTestLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.carbonite.qa.base.TestBase;

//This class is part of logic that Rerun the Failed Test cases
public class RetryFailedTest extends TestBase implements IRetryAnalyzer {

	int counter = 0;
	int maxRetry = 2;

	@Override
	public boolean retry(ITestResult result) {

		logger.info("Retrying Failed Test Case");

		if (counter < maxRetry) {

			counter++;

			return true;
		}

		return false;
	}

}
