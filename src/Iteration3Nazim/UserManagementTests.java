package Iteration3Nazim;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserManagementTests {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown() {
        
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    public void loadAdminDashboard() {
        driver.get("http://localhost:3000");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]")));
        inputField.sendKeys("admin@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]")));
        passwordField.sendKeys("admin1234");

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]")));
        submitBtn.click();

        wait.until(ExpectedConditions.urlContains("/AdminHome"));

        WebElement adminDashboardLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[3]/div[1]/h4/a")));
        adminDashboardLink.click();

        wait.until(ExpectedConditions.urlContains("/AdminDashboard"));

        WebElement userManagementBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/a")));
        userManagementBtn.click();

        wait.until(ExpectedConditions.urlContains("/UserManagement"));
    }

    @Test
     void testEditProfileButtonPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editProfileBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[1]")));
        Assertions.assertTrue(editProfileBtn.isDisplayed(), "Edit Profile button should be displayed");
    }

    @Test
     void testSuspendAccountButtonPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suspendAccountBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[2]")));
        Assertions.assertTrue(suspendAccountBtn.isDisplayed(), "Suspend Account button should be displayed");
    }

    @Test
     void testDeleteAccountButtonPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteAccountBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[3]")));
        Assertions.assertTrue(deleteAccountBtn.isDisplayed(), "Delete Account button should be displayed");
    }

    @Test
     void testRestoreButtonPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement restoreBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[4]")));
        Assertions.assertTrue(restoreBtn.isDisplayed(), "Restore button should be displayed");
    }

    @Test
     void testDeleteProfileButtonPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteProfileBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[5]")));
        Assertions.assertTrue(deleteProfileBtn.isDisplayed(), "Delete Profile button should be displayed");
    }

    @Test
     void testRestoreProfileButtonPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement restoreProfileBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[6]")));
        Assertions.assertTrue(restoreProfileBtn.isDisplayed(), "Restore Profile button should be displayed");
    }
}