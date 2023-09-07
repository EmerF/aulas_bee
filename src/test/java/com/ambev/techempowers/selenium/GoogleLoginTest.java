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

            // Close the browser
            driver.quit();
        }
    }

