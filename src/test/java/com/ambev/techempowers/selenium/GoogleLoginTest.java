package com.ambev.techempowers.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GoogleLoginTest {

        @Test
        public void testLogin() {

            WebDriverManager.chromedriver().setup();

            // Create a WebDriver instance
            WebDriver driver = new ChromeDriver();

            // Navigate to the Google login page
            driver.get("http://www.globo.com");

            // Find the "Email or phone" input field and enter your Google email address
            WebElement emailInput = driver.findElement(By.id("header-search-input"));
            emailInput.sendKeys("java");
            emailInput.sendKeys(Keys.RETURN );

            // Click the "Next" button to proceed to the password input
            WebElement nextButton = driver.findElement(By.id("identifierNext"));
            nextButton.click();

            // Wait for the password input field to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

            // Enter your Google account password
            passwordInput.sendKeys("your_password");

            // Click the "Next" button to log in
            WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
            passwordNextButton.click();

            // Wait for a while to see the result before closing the browser
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Close the browser
            driver.quit();
        }
    }

