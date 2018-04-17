import org.openqa.selenium.support.PageFactory;

/**
 * Created by asirota on 4/3/2018.
 */
public class Navigation {

	public static GoogleMainPage openGoogleMainPage() {
		BrowserManager.browser.get("http://google.com");
		return PageFactory.initElements(BrowserManager.browser, GoogleMainPage.class);
	}

}
