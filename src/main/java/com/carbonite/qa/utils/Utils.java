package com.carbonite.qa.utils;

import org.apache.commons.lang3.RandomStringUtils;

import com.carbonite.qa.base.TestBase;

public class Utils extends TestBase {

	public static long IMPLICIT_WAIT = 10;
	public static long PAGE_LOADOUT_WAIT = 20;

	public static String generateRandomEmail() {

		String email = RandomStringUtils.randomNumeric(3);

		String emailID = "Manvir" + email + "@gmail.com";

		return emailID;

	}

	public static String generateRandomPassword() {

		String randomStringForPassword = RandomStringUtils.randomNumeric(3);

		String password = "Manager@" + randomStringForPassword;

		return password;

	}

}
