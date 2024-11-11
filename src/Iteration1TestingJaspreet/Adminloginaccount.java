package Iteration1TestingJaspreet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Adminloginaccount {
	
	WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    private void loadHomePage() {
        driver.get("http://localhost:3000");
    }


	@Test
	  public void adminloginwithemail() {
	      loadHomePage();

	     
	     


	      WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]\r\n"
	      		+ ""));
	      emailField.sendKeys("admin@gmail.com\r\n"
	      		+ "");

	      WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]\r\n"
	      		+ ""));
	      passwordField.sendKeys("admin1234");

	      
	      WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]\r\n"
	      		+ ""));
	      submitButton.click();
	      
	     
	  }
	
	
	
}
