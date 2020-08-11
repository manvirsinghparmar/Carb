
package com.carbonite.qa.RetryFailedTestLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.carbonite.qa.base.TestBase;

//This class is part of logic that Rerun the Failed Test cases
public class RetryFailedTest implements IRetryAnalyzer {

	int counter = 0;
	int maxRetry = 3;

	@Override
	public boolean retry(ITestResult result) {

		if (counter < maxRetry) {

			counter++;

			return true;
		}

		return false;
	}

}
