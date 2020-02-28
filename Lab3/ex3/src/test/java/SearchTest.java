import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
    private WebDriver driver;

    @BeforeEach

    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void verifyThatStockholmCanBeFound() {
        HomePage home = new HomePage(driver);
        SearchResultPage searchResult = home.searchFor("Stockholm");

        LocationPage stockholm = searchResult.clickOnTopSearchResultLink();

        String expected = "Stockholm";
        String actual = stockholm.getHeadLine();
        Assertions.assertTrue(actual.contains(expected));
    }
}

