import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

public class MyStepdefs {

    private final WebDriver driver = new ChromeDriver();;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        js = (JavascriptExecutor) driver;
    }
    @Given("I am on the Google search page")
    public void iAmOnTheGoogleSearchPage() {
        driver.get("https://www.google.pt/");
        driver.manage().window().setSize(new Dimension(1296, 741));
    }

    @When("I search for {string}")
    public void iSearchFor(String query) {
        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("the page title should start with {string}")
    public void thePageTitleShouldStartWith(String titleStartsWith) {
        driver.findElement(By.id("res")).click();
        assertThat(driver.getTitle(),containsString(titleStartsWith));
    }

    @AfterEach()
    public void closeBrowser() {
        driver.quit();
    }
}
