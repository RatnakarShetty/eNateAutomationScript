package com.enate.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.enate.pages.GuestDetailsPage;
import com.enate.pages.HomePage;
import com.enate.pages.SeatSelectionPage;

import generics.BaseTest;
import generics.WebDriverUtilityLib;

public class TicketBookingTest extends BaseTest {

	@Test
	public void testTicketBooking() throws InterruptedException, EncryptedDocumentException, InvalidFormatException,
			FileNotFoundException, IOException {

		
		//Reading data from Excel sheet 
		String MovieName = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 0);
		String bookingDate = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 1);
		String bookingMonth = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 2);
		String bookingYear = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 3);
		String seatNo = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 4);

		String firstName = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 5);
		String lastName = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 6);
		String email = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 7);
		String confirmEmail = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 8);
		String phoneNo = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 9);
		String cardNo = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 10);
		String cardHolderName = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 11);
		String cvv = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 12);
		String cvvExpiry = WebDriverUtilityLib.getCellValue(INPUT_PATH, "TicketBookingTest", 1, 13);

		HomePage homePage = new HomePage(driver);

		// Search for Movie Name
		homePage.searchForMovie(MovieName);
		homePage.selectMovie();
		
		Thread.sleep(5000);
		// Click Book Now Button
		homePage.clickBookNow();

		Thread.sleep(5000);

		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				// System.out.println("1 " + driver.getTitle());

			}
		}

		// Select the prefered date
		homePage.clickBookingDate(bookingDate, bookingMonth, bookingYear);

		Thread.sleep(5000);

		driver.switchTo().frame(0);

		Thread.sleep(5000);

		SeatSelectionPage seatPage = new SeatSelectionPage(driver);

		// Select the prefered seat
		seatPage.selectSeat(seatNo);

		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		// Click Next Button to Navigate GuestDetails Page
		seatPage.clickNextBtn();

		GuestDetailsPage guestDetailsPage = new GuestDetailsPage(driver);

		// Enter All The Details To Complete The Booking
		guestDetailsPage.enterFirstName(firstName);
		guestDetailsPage.enterLastName(lastName);
		guestDetailsPage.enterEmail(email);
		guestDetailsPage.enterConfirmEmail(confirmEmail);
		guestDetailsPage.enterPhoneNumber(phoneNo);
		guestDetailsPage.enterCardHolderName(cardHolderName);
		guestDetailsPage.enterCVV(cvv);
		guestDetailsPage.enterCardExpiry(cvvExpiry);
		guestDetailsPage.enterCardNumber(cardNo);

		guestDetailsPage.clickCompleteMyBookingBtn();
		
		Thread.sleep(1000);
		guestDetailsPage.validateErrorMessage("Invalid card details");

	}

}
