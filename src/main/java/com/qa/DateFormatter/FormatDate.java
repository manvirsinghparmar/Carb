package com.qa.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//This Program converts the format of todays date into other formats...........
public class FormatDate {

	public static void main(String[] args) {

		System.out.println("This Program converts the format of todays date into other formats...........");
		System.out.println("");

		FormatDate fd = new FormatDate();

		Date todaysDate = fd.dateProvider();

		System.out.println("Today Date is : " + todaysDate);

		String formatToBeConvertedInto = fd.formatDate();

		fd.dateFormatter(todaysDate, formatToBeConvertedInto);

	}

	// Method to Convert Date Format
	public void dateFormatter(Date date, String Format) {

		System.out.println("*********************************************************************");

		try {

			SimpleDateFormat dateFormatter = new SimpleDateFormat(Format);
			String dateformat = dateFormatter.format(date);

			switch (Format) {
			case "dd-MM-yyyy":
				System.out.println(" Formatted Date to dd-mm-yyyy is : " + dateformat);
				break;

			case "dd/MM/yyyy":
				System.out.println(" Formatted Date to dd/mm/yyyy is : " + dateformat);
				break;

			case "dd:MM:yyyy":
				System.out.println("Formatted Date to dd:mm:yyyy is : " + dateformat);
				break;

			case "MM-dd-yyyy":
				System.out.println("Formatted Date to mm-dd-yyyy is : " + dateformat);
				break;
				
				default:
					System.out.println("Valid Format not entered");

			}

		} catch (IllegalArgumentException e) {
			System.out.println("You entered an invalid Format!!!!!");
		}

	}

	// Method takes input from user for the format in which date has to be changed
	public String formatDate() {

		Scanner scan = new Scanner(System.in);

		System.out.println("");

		System.out.println("Valid Date Formats  are: ");
		System.out.println("1: dd-MM-yyyy");
		System.out.println("2: dd/MM/yyyy");
		System.out.println("3: dd:MM:yyyy");
		System.out.println("4: MM-dd-yyyy");

		System.out.println("");

		System.out.println("Enter the format(case sensitive) in which you want the date: ");

		String format = scan.next();

		scan.close();

		return format;
	}

	// Method to Provide today's Date
	public Date dateProvider() {

		return new Date();
	}

}
