package com.enate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generics.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath = "//form[@id='search-form']/input[@placeholder='Search']")
	private WebElement searchBox;

	@FindBy(xpath = "//a/div[text()='Book Now']")
	private WebElement bookNowBtn;
	

	private WebElement bookingDate;	
	public void getDateToBeBook(String strbookingDate,String strbookingMonth,String strbookingYear){
		//System.out.println("//span[text()='"+strbookingMonth+" "+strbookingYear+"']/parent::div/following-sibling::div//span[text()="+strbookingDate+"]/../..");
		bookingDate = driver.findElement(By.xpath("//span[text()='"+strbookingMonth+" "+strbookingYear+"']/parent::div/following-sibling::div//span[text()="+strbookingDate+"]/../.."));
		}
	
	
	
	//https://stackoverflow.com/questions/21263367/webdriver-pageobject-findby-how-to-specify-xpath-with-dynamic-value

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void searchForMovie(String movieName) {
		searchBox.sendKeys(movieName);
	}
	
	public void selectMovie() {
		searchBox.sendKeys(Keys.ENTER);
	}

	public void clickBookNow() {
		bookNowBtn.click();
	}
	
	public void clickBookingDate(String date,String month,String year) {
		getDateToBeBook(date,month,year);
		bookingDate.click();
	}

}
