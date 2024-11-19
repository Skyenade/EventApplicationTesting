package Iteration2TestingByNazim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class UserProfileUpdateTests {

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
    void testUpdateUserProfile() {
        loadLoginPage();
        login("test01@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userprofile-button']")));
        profileButton.click();

        WebElement profilePageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='User Profile']")));
        assertTrue(profilePageHeader.isDisplayed());

        WebElement nameField = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/input"));
        nameField.clear();
        nameField.sendKeys("New User Name");

        WebElement bioField = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/textarea"));
        bioField.clear();
        bioField.sendKeys("This is my updated bio.");

        WebElement saveButton = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/button[2]"));
        saveButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Profile updated successfully']")));
        assertTrue(successMessage.isDisplayed());

        WebElement updatedName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/p[1]")));
        assertEquals("New User Name", updatedName.getText());
        assertEquals("This is my updated bio.", bioField.getAttribute("value"));
    }

    @Test
    void testUpdateUserProfileWithSpecialCharsAndNumbers() {
        loadLoginPage();
        login("test01@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userprofile-button']")));
        profileButton.click();

        WebElement profilePageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='User Profile']")));
        assertTrue(profilePageHeader.isDisplayed());

        WebElement nameField = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/input"));
        nameField.clear();
        nameField.sendKeys("User123!@#");

        WebElement bioField = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/textarea"));
        bioField.clear();
        bioField.sendKeys("This is my bio with special characters !@#$%^&*()123.");

        WebElement saveButton = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/button[2]"));
        saveButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Profile updated successfully']")));
        assertTrue(successMessage.isDisplayed());

        WebElement updatedName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/p[1]")));
        assertEquals("User123!@#", updatedName.getText());

        assertEquals("This is my bio with special characters !@#$%^&*()123.", bioField.getAttribute("value"));
    }
}