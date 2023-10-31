package com.ambev.techempowers.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features", // Location of your feature files
        glue = "com.ambev.techempowers.cucumber", // Package where your step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class CucumberTestRunner {
}

