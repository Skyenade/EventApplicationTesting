package Iteration1TestsMaina;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AdminDashboardTests {

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
    void testCorrectLogin() {
        loadLoginPage();
        login("admin@gmail.com", "admin1234");
        assertEquals("http://localhost:3000/AdminHome", driver.getCurrentUrl());
    }

    @Test
    void testWrongEmail() {
        loadLoginPage();
        login("wrong@gmail.com", "admin1234");
        assertEquals("http://localhost:3000/AdminHome", driver.getCurrentUrl());
    }

    @Test
    void testWrongPassword() {
        loadLoginPage();
        login("admin@gmail.com", "wrongpassword");
        assertNotEquals("http://localhost:3000/AdminHome", driver.getCurrentUrl());
    }

    @Test
    void testEmptyEmail() {
        loadLoginPage();
        login("", "admin1234");
        assertNotEquals("http://localhost:3000/AdminHome", driver.getCurrentUrl());
    }

    @Test
    void testEmptyPassword() {
        loadLoginPage();
        login("admin@gmail.com", "");
        assertNotEquals("http://localhost:3000/AdminHome", driver.getCurrentUrl());
    }

    @Test
    void testEmptyCredentials() {
        loadLoginPage();
        login("", "");
        assertNotEquals("http://localhost:3000/AdminHome", driver.getCurrentUrl());
    }
}