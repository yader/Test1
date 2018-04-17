import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by asirota on 4/14/2018.
 */
public class GoogleMenu {

	@FindBy(css = ".hdtb-imb")
	WebElement imagesLink;

	public GoogleImagesPage clickOnImagesResults() {
		imagesLink.click();
		return new GoogleImagesPage();
	}

	public SearchResultsPage clickOnAllResults() {
		BrowserManager.browser.findElement(By.cssSelector(".hdtb-imb")).click();
		return new SearchResultsPage();
	}
}
