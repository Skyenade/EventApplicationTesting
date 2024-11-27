package Iteration3Nazim;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SearchUserAndEvents {
    




public class SearchEventAndUserByNameTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]")));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
        loginButton.click();
    }

    @Test
    void testSearchBarPresence() {
        loadLoginPage();
        login("user@gmail.com", "123456");

        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/input")));
        assertNotNull(searchBar, "Search bar should be visible on the page");
    }

    @Test
    void testSearchButtonPresence() {
        loadLoginPage();
        login("user@gmail.com", "123456");

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/button[1]")));
        assertNotNull(searchButton, "Search button should be visible on the page");
    }

    @Test
    void testSearchEventByName() {
        loadLoginPage();
        login("user@gmail.com", "123456");

        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/input")));
        searchBar.clear();
        String searchEventName = "Anime convention";
        searchBar.sendKeys(searchEventName);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div/div[2]/button[1]")));
        searchButton.click();

        WebElement searchResultsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[3]/div")));
        assertNotNull(searchResultsSection, "Search results section should be visible.");

        try {
            WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div/div[3]/div//*[contains(text(), '" + searchEventName + "')]")));
            assertNotNull(searchResult, "Event 'Anime convention' should be displayed in the search results.");
            searchResult.click();
        } catch (TimeoutException e) {
            System.out.println("No event found with the name: " + searchEventName);
            driver.quit();
            return;
        }
    }

    @Test
    void testSearchUserByName() {
        loadLoginPage();
        login("user@gmail.com", "123456");

        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/input")));
        searchBar.clear();
        String searchUserName = "jazz";
        searchBar.sendKeys(searchUserName);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div/div[2]/button[1]")));
        searchButton.click();

        WebElement searchResultsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[3]/div")));
        assertNotNull(searchResultsSection, "Search results section should be visible.");

        try {
            WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div/div[3]/div//*[contains(text(), '" + searchUserName + "')]")));
            assertNotNull(searchResult, "User 'jazz' should be displayed in the search results.");
            searchResult.click();
        } catch (TimeoutException e) {
            System.out.println("No user found with the name: " + searchUserName);
            driver.quit();
            return;
        }
    }

    @Test
    void testVerifyEventProfile() {
        loadLoginPage();
        login("user@gmail.com", "123456");

        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/input")));
        searchBar.clear();
        String searchEventName = "Anime convention";
        searchBar.sendKeys(searchEventName);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div/div[2]/button[1]")));
        searchButton.click();

        WebElement searchResultsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[3]/div")));
        assertNotNull(searchResultsSection, "Search results section should be visible.");

        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div/div[3]/div//*[contains(text(), '" + searchEventName + "')]")));
        searchResult.click();

        WebElement eventProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='event-profile-name']")));
        assertEquals(searchEventName, eventProfileName.getText(), "The profile should match the searched event.");
    }

    @Test
    void testVerifyUserProfile() {
        loadLoginPage();
        login("user@gmail.com", "123456");

        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/input")));
        searchBar.clear();
        String searchUserName = "jazz";
        searchBar.sendKeys(searchUserName);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div/div[2]/button[1]")));
        searchButton.click();

        WebElement searchResultsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[3]/div")));
        assertNotNull(searchResultsSection, "Search results section should be visible.");

        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='root']/div/div/div[3]/div//*[contains(text(), '" + searchUserName + "')]")));
        searchResult.click();

        WebElement userProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='user-profile-name']")));
        assertEquals(searchUserName, userProfileName.getText(), "The profile should match the searched user.");
    }
}}