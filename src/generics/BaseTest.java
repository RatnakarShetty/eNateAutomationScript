package generics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(WebDriverListners.class)
public class BaseTest implements WebDriverConstants {

	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void setDriverPath() {

		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);

	}

	@BeforeMethod(alwaysRun = true)
	public void openApp() throws MalformedURLException {

		driver = new ChromeDriver();
		Reporter.log("Browser Opend", true);
		Reporter.log("Browser Opend", true);
		driver.manage().window().maximize();
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://book.london-theater-tickets.com/");
	}

	@AfterMethod(alwaysRun = true)
	public void closeApp() {
		//driver.quit();
	}

}
