package com.enate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import generics.BasePage;

public class GuestDetailsPage extends BasePage {

	public GuestDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='toast']/span")
	private WebElement errMsg;

	@FindBy(xpath = "//input[@name='First Name']")
	private WebElement firstNameTxBx;

	@FindBy(xpath = "//input[@name='Last Name']")
	private WebElement lastNameTxBx;

	@FindBy(xpath = "//input[@name='Email']")
	private WebElement emailTxBX;

	@FindBy(xpath = "//input[@name='Confirm Email']")
	private WebElement confirmEmailTxBx;

	@FindBy(xpath = "//input[@name='Phone']")
	private WebElement phoneTxBx;

	@FindBy(xpath = "//input[@name='Card Number']")
	private WebElement cardNumberTxBx;

	@FindBy(xpath = "//input[@name='Card Holder Name']")
	private WebElement cardHolderNameTxBx;

	@FindBy(id = "card-expiry")
	private WebElement cardExpiryTxBx;

	@FindBy(name = "CVV")
	private WebElement cvvTxBx;

	@FindBy(xpath = "//span[text()='COMPLETE MY BOOKING']/../..")
	private WebElement completeMyBookingBtn;

	public void enterFirstName(String firstName) {
		firstNameTxBx.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameTxBx.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		emailTxBX.sendKeys(email);
	}

	public void enterConfirmEmail(String confirmEmail) {
		confirmEmailTxBx.sendKeys(confirmEmail);
	}

	public void enterCVV(String CVV) {
		cvvTxBx.sendKeys(CVV);
	}

	public void enterCardHolderName(String cardHolderName) {
		cardHolderNameTxBx.sendKeys(cardHolderName);
	}

	public void enterCardNumber(String cardNumber) {
		cardNumberTxBx.sendKeys(cardNumber);
	}

	public void enterPhoneNumber(String phoneNo) {
		phoneTxBx.sendKeys(phoneNo);
	}

	public void enterCardExpiry(String expiry) {
		cardExpiryTxBx.sendKeys(expiry);
	}

	public void clickCompleteMyBookingBtn() {
		completeMyBookingBtn.click();
	}

	public void validateErrorMessage(String expErrorMsg) {

		String actErrorMsg = driver.findElement(By.xpath("//div[@id='toast']/span")).getText();

		Assert.assertEquals(actErrorMsg, expErrorMsg);

	}

}
