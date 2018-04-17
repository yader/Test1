import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by asirota on 4/3/2018.
 */
public class SearchResultsPage extends GoogleMenu {

	@FindBy(id = "resultStats")
	WebElement numberOfResults;

	@FindBy(xpath = "//td/a[@class='fl']")
	List<WebElement> pageNumberLinks;

	public int getNumberOfResults() {
		String numberOfResultsInText = numberOfResults.getText();
		String numbersAsText = numberOfResultsInText.split(":")[1].split("\\(")[0];
		String numberAsTextWithoutSpaces = numbersAsText.replaceAll(" ", "");
		return Integer.parseInt(numberAsTextWithoutSpaces);
	}

	public boolean isNumberOfResultsPresent() {
		return numberOfResults.isDisplayed();
	}

	public SearchResultsPage clickOnPageNumber(int pageNumber) {
		pageNumberLinks.get(pageNumber).click();
		return PageFactory.initElements(BrowserManager.browser, SearchResultsPage.class);
	}
}
