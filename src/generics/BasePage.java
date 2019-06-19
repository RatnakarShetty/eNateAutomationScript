package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void verifyTitle(String eTitle) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching: " + eTitle, true);
		} catch (Exception e) {
			Reporter.log("Title is not matching" + eTitle, true);
			Assert.fail();

		}

	}

	public void verifyElementIsPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present", true);
		} catch (Exception e) {
			Reporter.log("Elemwnt is not present", true);
			Assert.fail();
		}

	}

}
