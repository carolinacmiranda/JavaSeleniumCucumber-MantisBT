package com.example.hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseTest {

    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://mantis-prova.base2.com.br/login_page.php");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After(order = 1)
    public void screenshot(Scenario scenario) {
        if (driver != null) {
            File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File("target/screenshots/"+scenario.getId()+".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @After(order = 0)
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    } 
}
