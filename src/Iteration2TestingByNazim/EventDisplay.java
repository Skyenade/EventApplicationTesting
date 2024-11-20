package Iteration2TestingByNazim;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class EventDisplay {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void loadLoginPage() {
        driver.get("http://localhost:3000");
    }

    private void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]")));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
        loginButton.click();
    }

    @Test
    void testEventsAreVisible() {
        loadLoginPage();
        login("test01@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]")));
        WebElement secondEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[2]")));

        assertTrue(firstEvent.isDisplayed(), "First event should be visible.");
        assertTrue(secondEvent.isDisplayed(), "Second event should be visible.");
    }
}