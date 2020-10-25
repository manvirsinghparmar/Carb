package com.carbonite.qa.RetryFailedTestLogic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

//This class is part of logic that Rerun the Failed Test cases
public class TransformerForRetry implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(RetryFailedTest.class);

	}

}
