package Iteration2TestingByNazim;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class UserProfileUpdateTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void login(String email, String password) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]")));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
        loginButton.click();
    }

    private void navigateToUserProfile() {
        WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userprofile-button']")));
        profileButton.click();
    }

    @Test
    void testProfileButtonPresence() {
        login("test01@gmail.com", "123456");
        WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userprofile-button']")));
        assertNotNull(profileButton, "Profile button should be present.");
    }

    @Test
    void testProfilePageHeaderPresence() {
        login("test01@gmail.com", "123456");
        navigateToUserProfile();

        WebElement profilePageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='User Profile']")));
        assertTrue(profilePageHeader.isDisplayed(), "User Profile header should be displayed.");
    }

    @Test
    void testNameFieldEditable() {
        login("test01@gmail.com", "123456");
        navigateToUserProfile();

        WebElement nameField = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/input"));
        nameField.clear();
        nameField.sendKeys("New User Name");

        assertEquals("New User Name", nameField.getAttribute("value"), "Name field should be updated.");
    }

    @Test
    void testBioFieldEditable() {
        login("test01@gmail.com", "123456");
        navigateToUserProfile();

        WebElement bioField = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/textarea"));
        bioField.clear();
        bioField.sendKeys("This is my updated bio.");

        assertEquals("This is my updated bio.", bioField.getAttribute("value"), "Bio field should be updated.");
    }

    @Test
    void testSaveButtonPresence() {
        login("test01@gmail.com", "123456");
        navigateToUserProfile();

        WebElement saveButton = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/button[2]"));
        assertNotNull(saveButton, "Save button should be present.");
    }

    @Test
    void testSaveProfileSuccessMessage() {
        login("test01@gmail.com", "123456");
        navigateToUserProfile();

        WebElement nameField = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/input"));
        nameField.clear();
        nameField.sendKeys("New User Name");

        WebElement bioField = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/textarea"));
        bioField.clear();
        bioField.sendKeys("This is my updated bio.");

        WebElement saveButton = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/button[2]"));
        saveButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Profile updated successfully']")));
        assertTrue(successMessage.isDisplayed(), "Success message should be displayed after saving profile.");
    }

    @Test
    void testUpdatedNameDisplayed() {
        login("test01@gmail.com", "123456");
        navigateToUserProfile();

        WebElement nameField = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/input"));
        nameField.clear();
        nameField.sendKeys("New User Name");

        WebElement saveButton = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/button[2]"));
        saveButton.click();

        WebElement updatedName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/p[1]")));
        assertEquals("New User Name", updatedName.getText(), "Updated name should be displayed on the profile page.");
    }
}