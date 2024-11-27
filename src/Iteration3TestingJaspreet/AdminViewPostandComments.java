package Iteration3TestingJaspreet;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AdminViewPostandComments {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();  
    }

    private void loadHomePage() {
        driver.get("http://localhost:3000");
    }

    private void loginAsAdmin() {
        loadHomePage();
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]")).sendKeys("admin@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).sendKeys("admin1234");
        driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]")).click();
    }

    @Test
    void testViewComments() {
        loginAsAdmin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewCommentsButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[2]/button[4]")
        ));
        viewCommentsButton.click();

        assertTrue(viewCommentsButton.isDisplayed(), "The View Comments button should be visible.");
    }

    @Test
    void testViewLikes() {
        loginAsAdmin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewLikes = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[1]/p[1]")
        ));
        assertTrue(viewLikes.isDisplayed(), "Likes should be visible.");
    }

    @Test
    void testViewDislikes() {
        loginAsAdmin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewDislikes = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[1]/p[2]")
        ));
        assertTrue(viewDislikes.isDisplayed(), "Dislikes should be visible.");
    }

    @Test
    void testViewAttendees() {
        loginAsAdmin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewAttendees = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[1]/p[3]")
        ));
        assertTrue(viewAttendees.isDisplayed(), "Attendees should be visible.");
    }

    @Test
    void testViewNotifications() {
        loginAsAdmin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewNotifications = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[4]/div[2]/div[2]/ul/li[1]")
        ));
        assertTrue(viewNotifications.isDisplayed(), "Notifications should be visible.");
    }

    @Test
    void testLikeButtonClickableAndClick() {
        loginAsAdmin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[2]/button[1]")
        ));
        assertTrue(likeButton.isEnabled(), "The Like button should be enabled.");

        likeButton.click();

        WebElement likeCount = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[1]/p[1]"));
        assertTrue(likeCount.getText().contains("1"), "The Like count should increase after clicking the Like button.");
    }

    @Test
    void testDislikeButtonClickableAndClick() {
        loginAsAdmin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dislikeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("dislike_btn")
        ));
        assertTrue(dislikeButton.isEnabled(), "The Dislike button should be enabled.");

        dislikeButton.click();
    }

    @Test
    void LIKEButtonUsingClassNameAndClick() {
        loginAsAdmin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("like_btn")
        ));
        assertTrue(likeButton.isEnabled(), "The Like button should be enabled.");

        likeButton.click();
    }
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();  
        }
    }
}
