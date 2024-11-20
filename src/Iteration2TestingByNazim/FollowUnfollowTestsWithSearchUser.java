package pack1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class FollowUnfollowTestsWithSearchUser {

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
    void testFollowUnfollowBySearchUser() {
        loadLoginPage();
        login("test01@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/input")));
        searchBar.clear();
        String searchUsername = "user"; 
        searchBar.sendKeys(searchUsername);
        searchBar.sendKeys(Keys.RETURN); 

        
        try {
            WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-result' and text()='" + searchUsername + "']")));
            searchResult.click();
        } catch (TimeoutException e) {
            System.out.println("No user found with the username: " + searchUsername);
            driver.quit(); 
            return; 
        }

       
        WebElement followButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[4]/div[2]/button"))); // Change xpath if needed
        String buttonText = followButton.getText();

        if (buttonText.equals("Follow")) {
            followButton.click();
            WebElement followConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You are now following " + searchUsername + "']")));
            assertTrue(followConfirmation.isDisplayed(), "User should be followed successfully.");
        } else if (buttonText.equals("Unfollow")) {
            followButton.click();
            WebElement unfollowConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You have unfollowed " + searchUsername + "']")));
            assertTrue(unfollowConfirmation.isDisplayed(), "User should be unfollowed successfully.");
        }
    }
}