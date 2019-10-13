import config.LocalConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseClass;
import org.testng.annotations.TestInstance;
import pages.GoogleHomePage;
import pages.GoogleSearchResultsPage;


public class GoogleSearchTest extends BaseClass {
    private static Logger log = Logger.getLogger(GoogleSearchTest.class);
    private static GoogleHomePage searchPage;
    private static GoogleSearchResultsPage resultsPage;

    @Test
    public void verifySearchTerm_isPresentInSearchResults() {
        searchPage = new GoogleHomePage(driver);
        searchPage.enterSearchTerm(LocalConfig.INSTANCE.getSearchTerm());
        resultsPage = new GoogleSearchResultsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(resultsPage.RESULTS_TEXT));
        log.info("Search Term is : " + LocalConfig.INSTANCE.getSearchTerm());
        log.info("First Search result is : " + resultsPage.RESULTS.getText());

        Assert.assertTrue(containsWords(resultsPage.RESULTS.getText(), LocalConfig.INSTANCE.getSearchTerm().split(" ")),
                "Search term : " + LocalConfig.INSTANCE.getSearchTerm() + " is not present in first Search Result ");

    }

    @Test
    public void verifySearchTerm_Mouse() {
        searchPage = new GoogleHomePage(driver);
        searchPage.enterSearchTermUsingMouse(LocalConfig.INSTANCE.getSearchTerm());
        resultsPage = new GoogleSearchResultsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(resultsPage.RESULTS_TEXT));
        log.info("Search Term is : " + LocalConfig.INSTANCE.getSearchTerm());
        log.info("First Search result is : " + resultsPage.RESULTS.getText());

        Assert.assertTrue(containsWords(resultsPage.RESULTS.getText(), LocalConfig.INSTANCE.getSearchTerm().split(" ")),
                "Search term : " + LocalConfig.INSTANCE.getSearchTerm() + " is not present in first Search Result ");

    }


    public static boolean containsWords(String inputString, String[] words) {
        for (String word : words) {
            if (inputString.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
