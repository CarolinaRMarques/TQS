import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchStepDefinitions {
    private WebDriver driver;
    private HomePage home;
    private SearchResultPage searchResult;

    @BeforeEach
    public void prepare() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void cleanUp() {
        driver.close();
    }

    //@Given("^I want to know the weather forecast for coming days$")
    public void prepareHomePage() {
        home = new HomePage(driver);
    }

    //@When("^I search for (.*)$")
    public void search(String location) {
        searchResult = home.searchFor(location);
    }

    //@Then("^I should be able to get a weather forecast for (.*)$")
    public void assertTheSearchResult(String locationName) {
        LocationPage location = searchResult.clickOnTopSearchResultLink();
        String actualHeadLine = location.getHeadLine();

        Assertions.assertTrue(actualHeadLine.contains(locationName));
    }
}
