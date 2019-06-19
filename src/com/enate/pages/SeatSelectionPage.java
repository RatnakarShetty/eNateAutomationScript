package com.enate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generics.BasePage;

public class SeatSelectionPage extends BasePage {

	public SeatSelectionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(.,'NEXT')]/../..//div[@class='next-button selectable']")
	private WebElement nextBtn;

	private WebElement seatToBeSelect;

	public void getSeatToBeBook(String strSeatNoToBook) {
		//System.out.println("//*[name()='circle' and @id='SE-GRANDCIRCLE-E-" + strSeatNoToBook + "']");
		seatToBeSelect = driver
				.findElement(By.xpath("//*[name()='circle' and @id='SE-GRANDCIRCLE-E-" + strSeatNoToBook + "']"));
	}

	public void selectSeat(String seatNo) {
		getSeatToBeBook(seatNo);
		seatToBeSelect.click();
	}

	public void clickNextBtn() {
		nextBtn.click();
	}

}
