import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by asirota on 4/1/2018.
 */
public class GoogleTest {

	private static final String SEARCH_REQUEST = "car";

	@BeforeClass
	public void browser() {
		BrowserManager.openBrowser();
	}

	@Test(priority = 1)
	public void testSearch() {
		BrowserManager.openBrowser();
		SearchResultsPage searchResultsPage = Navigation.openGoogleMainPage()
				.searchForText(SEARCH_REQUEST)
				.clickOnPageNumber(1);
		assertTrue(searchResultsPage.isNumberOfResultsPresent(), "Should be present");
	}

	@Test(priority = 2)
	public void getNumberOfResultsTest() {
		int numberOfResults = Navigation.openGoogleMainPage()
				.searchForText(SEARCH_REQUEST).getNumberOfResults();
		assertEquals(numberOfResults, 100, "A should contains B");
	}

	@AfterTest
	public void closeBrowser() {
		BrowserManager.closeBrowser();
	}
}
