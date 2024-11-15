package Iteration2TestingByNazim;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class FollowUnfollowTestsWithoutButton {

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

    private void searchUser(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/input")));
        searchBar.clear();
        searchBar.sendKeys(username);

        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-result' and text()='" + username + "']")));
        searchResult.click();
    }

    @Test
    void testFollowUnfollowByProfileToggle() {
        loadLoginPage();
        login("test01@gmail.com", "123456");

        searchUser("TargetUser");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        WebElement userProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[4]/div[1]")));
        userProfile.click();

        
        WebElement statusMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'You are now following')]")));
        assertTrue(statusMessage.isDisplayed(), "Follow action should display the appropriate status message.");

        
        userProfile.click();

        WebElement unfollowMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'You have unfollowed')]")));
        assertTrue(unfollowMessage.isDisplayed(), "Unfollow action should display the appropriate status message.");
    }
}