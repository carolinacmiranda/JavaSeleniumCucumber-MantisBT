package com.example.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = {"com.example.stepDefinitions", "com.example.hooks"},
    tags = "",
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = false,
    dryRun = false
)

public class RunnerTest {

}
