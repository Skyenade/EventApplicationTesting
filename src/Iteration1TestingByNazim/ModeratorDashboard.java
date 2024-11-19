package Iteration1TestingByNazim;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;



public class ModeratorDashboard {



    private WebDriver driver;

    @BeforeEach
    void setUp() {
        
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        // Quit the driver after each test
        if (driver != null) {
            driver.quit();
        }
    }

    
    private void loadLoginPage() {
        driver.get("http://localhost:3000");
    }

    // Helper method to perform login
    private void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate and interact with the email and password fields
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]")));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
        loginButton.click();
    }

    @Test
    void testModeratorLoginAndDashboardAccess() {
        loadLoginPage();
        login("moderator@gmail.com", "Moderator");

      
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/ModeratorHome"), "The moderator should be redirected to the dashboard after logging in.");

        driver.quit();
    }
    @Test
    void testWrongModeratorEmail() {
        loadLoginPage();
        login("wrongmoderator@gmail.com", "Moderator");

        
        String currentUrl = driver.getCurrentUrl();
        assertFalse(currentUrl.contains("/ModeratorHome"), "The moderator should not be redirected to the dashboard with a wrong email.");
    }

    @Test
    void testWrongModeratorPassword() {
        loadLoginPage();
        login("moderator@gmail.com", "wrongpassword");

        
        String currentUrl = driver.getCurrentUrl();
        assertFalse(currentUrl.contains("/ModeratorHome"), "The moderator should not be redirected to the dashboard with a wrong password.");
    }

    @Test
    void testEmptyModeratorEmail() {
        loadLoginPage();
        login("", "Moderator");

        
        String currentUrl = driver.getCurrentUrl();
        assertFalse(currentUrl.contains("/ModeratorHome"), "The moderator should not be redirected to the dashboard with empty email.");
    }

    @Test
    void testEmptyModeratorPassword() {
        loadLoginPage();
        login("moderator@gmail.com", "");

        
        String currentUrl = driver.getCurrentUrl();
        assertFalse(currentUrl.contains("/ModeratorHome"), "The moderator should not be redirected to the dashboard with empty password.");
    }

//    @Test
//    void testModeratorLogout() {
//        loadLoginPage();
//        login("moderator@gmail.com", "Moderator");
//
//       
//        WebElement logoutButton = driver.findElement(By.xpath("//*[@id='logout']"));
//        logoutButton.click();
//
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("http://localhost:3000"), "After logging out, the moderator should be redirected to the homepage.");
//    }
}