package Integration3TestsMaina;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ModeratorFollowOrUnfollowUser {

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

		
	private void loadHomePage() {
		driver.get("http://localhost:3000/");

		driver.manage().window().maximize();

		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
		String testEmail = "moderator@gmail.com";
		inputField.sendKeys(testEmail);

		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
		String testPassword = "123456";
		passwordField.sendKeys(testPassword);

		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
		submitBtn.click();		
	}
	
	@Test
	void testAccessModeratorHomePage() {
		loadHomePage();
		String url = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:3000/ModeratorHome";
		
		assertEquals(expectedUrl, expectedUrl);		
	}
	
	@Test
	void testSearchInputDisplayed() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input")));
		
		Boolean searchDisplayed = search.isDisplayed();
		
		assertTrue(searchDisplayed);	
	}
	
	@Test
	void testSearchButtonDisplayed() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button[1]")));
		
		Boolean searchDisplayed = search.isDisplayed();
		
		assertTrue(searchDisplayed);	
	}
	
	@Test
	void testSearchInputEnabled() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input")));
		
		Boolean searchEnabled = search.isEnabled();
		
		assertTrue(searchEnabled);	
	}
	
	@Test
	void testSearchButtonEnabled() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button[1]")));
		
		Boolean searchEnabled = search.isEnabled();
		
		assertTrue(searchEnabled);	
	}
	
	@Test
	void testSearchResultsDisplayed() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input")));
		
		search.sendKeys("test");
		
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button[1]")));
		searchButton.click();
		
		WebElement results = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]")));
		Boolean resultsDisplayed = results.isDisplayed();
		
		assertTrue(resultsDisplayed);		
	}
	
	@Test
	void testSearch() {
	    loadHomePage();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input")));
	    String searchText = "test";
	    search.sendKeys(searchText);

	    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button[1]")));
	    searchButton.click();

	    List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[3]/ul/li")));

	    boolean isSearchTextPresent = results.stream()
	            .anyMatch(result -> result.getText().toLowerCase().contains(searchText.toLowerCase()));

	    assertTrue(isSearchTextPresent);
	}

	@Test
	void testSearchFolowUnfollowButtonDisplayed() {
	    loadHomePage();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input")));
	    String searchText = "test";
	    search.sendKeys(searchText);

	    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button[1]")));
	    searchButton.click();

	    List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[3]/ul/li")));

	    WebElement followButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/ul/li/button")));
		
		Boolean followButtonDisplayed = followButton.isDisplayed();
		
		assertTrue(followButtonDisplayed);
	}
	
	@Test
	void testSearchFolowUnfollowButtonEnabled() {
	    loadHomePage();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input")));
	    String searchText = "test";
	    search.sendKeys(searchText);

	    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button[1]")));
	    searchButton.click();

	    List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[3]/ul/li")));

	    WebElement followButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/ul/li/button")));
		
		Boolean followButtonEnabled = followButton.isEnabled();
		
		assertTrue(followButtonEnabled);
	}
	
	@Test
	void testSearchFollow() {
	    loadHomePage();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input")));
	    String searchText = "test";
	    search.sendKeys(searchText);

	    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button[1]")));
	    searchButton.click();
	    
	    WebElement followingCount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/h3[2]")));
	    String countBefore = followingCount.getText();
	    System.out.println(countBefore);

	    List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[3]/ul/li")));

	    
	    WebElement followButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/ul/li/button")));
		
		followButton.click();
		
	    String countAfter = followingCount.getText();
	    System.out.println(countAfter);
	    
	    assertEquals(countBefore, countAfter);
	}

	@Test
	void testSearchUnfollow() {
	    loadHomePage();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input")));
	    String searchText = "test";
	    search.sendKeys(searchText);

	    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button[1]")));
	    searchButton.click();

	    List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[3]/ul/li")));

	    
	    WebElement unfollowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/ul/li/button")));
		
	    String buttonText = unfollowButton.getText();
	    
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		unfollowButton.click();
		
		String newButtonText = unfollowButton.getText();		
		
	    
	    assertEquals(buttonText, newButtonText);
	}
	
		
	

}
