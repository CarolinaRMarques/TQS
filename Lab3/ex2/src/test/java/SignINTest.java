import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;
public class SignINTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void signIN() {
    driver.get("http://demo.redmine.org/");
    driver.manage().window().setSize(new Dimension(1296, 741));
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).click();
    {
      WebElement element = driver.findElement(By.id("username"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("username")).sendKeys("CarolinaMarques");
    driver.findElement(By.id("password")).sendKeys("carol8956");
    driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Sign out")).click();
    driver.findElement(By.id("content")).click();
  }
}
