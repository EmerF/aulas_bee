package com.ambev.techempowers.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GloboStep {

    public WebDriver driver;

    @Before()
    void setup() {
        WebDriverManager.chromedriver(). setup();
    }

    @Given("the user is on the Globo.com homepage")
    public void theUserIsOnTheGloboComHomepage() {
        driver = new ChromeDriver();
        driver.get("http://www.globo.com");
    }

    @When("the user navigates to the g{int}.com website")
    public void theUserNavigatesToTheGComWebsite(int arg0) {
        driver.get("https://g1.globo.com/");
    }

    @Then("the g{int}.com homepage should be displayed")
    @Test
    public void theGComHomepageShouldBeDisplayed(int arg0) {
        WebElement header = driver.findElement(By.id("header-produto"));
        Assertions.assertNotNull(header);
        driver.close();
    }
}
