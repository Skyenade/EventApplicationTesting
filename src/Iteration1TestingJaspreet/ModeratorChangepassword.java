package Iteration1TestingJaspreet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ModeratorChangepassword {

	WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    private void loadHomePage() {
        driver.get("http://localhost:3000");
    }

    @Test
    public void Entermoderatoremail() {
        loadHomePage();
        
        WebElement  linkcheck = driver.findElement(By.xpath("/html/body/div/div/div/form/span\r\n"
      		
      		+ ""));
      linkcheck.click();
      
        WebElement Enteremail = driver.findElement(By.xpath("/html/body/div/div/div/form/input\r\n"
        		
        		+ ""));
        Enteremail.sendKeys("Testing@gmail.com");
        WebElement Resetbutton = driver.findElement(By.xpath("/html/body/div/div/div/form/button\r\n"
        		+ ""));
        Resetbutton.click();
    }

}
