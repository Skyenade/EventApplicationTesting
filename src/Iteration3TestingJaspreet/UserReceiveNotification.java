package Iteration3TestingJaspreet;

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

import static org.junit.jupiter.api.Assertions.*;

class UserReceiveNotification {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void loadHomePage() {
        driver.get("http://localhost:3000");
    }

    private void loginAsUser(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys(email);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[2]")));
        passwordField.sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/button[1]")));
        loginButton.click();
    }

    @Test
    void testViewFollowingDisplayAfterLogin() {
        loadHomePage();
        loginAsUser("jaspreet@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement followingDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[2]/div/h3")
        ));
        assertTrue(followingDisplay.isDisplayed(), "The 'Following' display should be visible after login.");
    }

    @Test
    void testNavigateToFollowersPage() {
        loadHomePage();
        loginAsUser("jaspreet@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement followersButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[1]/div[1]/button[3]")
        ));
        followersButton.click();

        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/MyFollowers"));
        assertEquals("http://localhost:3000/MyFollowers", driver.getCurrentUrl(), "The URL should be MyFollowers.");
    }

    @Test
    void viewTotalFollowers() {
        loadHomePage();
        loginAsUser("jaspreet@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement followersButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[1]/div[1]/button[3]")
        ));
        followersButton.click();

        WebElement totalFollowers = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[2]/div/p")
        ));

        assertTrue(totalFollowers.isDisplayed(), "The Total Followers display should be visible.");
        String followersText = totalFollowers.getText();
        assertNotNull(followersText, "The Total Followers display should contain text.");
        System.out.println("Followers Display Text: " + followersText);
    }

    @Test
    void testBackToHomeButton() {
        loadHomePage();
        loginAsUser("jaspreet@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement followersButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[1]/div[1]/button[3]")
        ));
        followersButton.click();

        WebElement backToHomeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[1]/div[1]/button[1]")
        ));
        assertTrue(backToHomeButton.isDisplayed(), "The 'Back to Home' button should be visible.");
        backToHomeButton.click();
    }

    @Test
    void viewLikes() {
        loadHomePage();
        loginAsUser("jaspreet@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement likeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[1]/p[1]")
        ));

        assertTrue(likeElement.isDisplayed(), "The Likes display should be visible.");
        String likeText = likeElement.getText();
        assertNotNull(likeText, "The Likes display should contain text.");
        System.out.println("Likes Display Text: " + likeText);
    }

    @Test
    void viewDislikes() {
        loadHomePage();
        loginAsUser("jaspreet@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement dislikeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[1]/p[2]")
        ));

        assertTrue(dislikeElement.isDisplayed(), "The Dislikes display should be visible.");
        String dislikeText = dislikeElement.getText();
        assertNotNull(dislikeText, "The Dislikes display should contain text.");
        System.out.println("Dislikes Display Text: " + dislikeText);
    }

    @Test
    void viewNotification() {
        loadHomePage();
        loginAsUser("jaspreet@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement notifButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("notif_viwedbtn")
        ));
        notifButton.click();

        Boolean notifButtonAfterClick = wait.until(ExpectedConditions.invisibilityOf(notifButton));
        assertTrue(notifButtonAfterClick, "Notification button should be disbale after clicking.");
    }
}
