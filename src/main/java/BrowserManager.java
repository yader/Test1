import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by asirota on 4/3/2018.
 */
public class BrowserManager {

	public static WebDriver browser;

	public static void openBrowser() {
		System.setProperty("browser", "chrome");
		String browserType = System.getProperty("browser");
		switch (browserType) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "./target/classes/geckodriver.exe");
				browser = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./target/classes/chromedriver.exe");
				browser = new ChromeDriver();
				break;
			default:
				Assert.fail("Wrong browser");
		}
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	public static GoogleMainPage openGoogleMainPage() {
		browser.get("http://google.com");
		return new GoogleMainPage();
	}

	public static void closeBrowser() {
		browser.quit();
	}
}
