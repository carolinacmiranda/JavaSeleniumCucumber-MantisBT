package com.example.pages;

import org.junit.Assert;
import java.time.Duration;
import com.example.hooks.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    private WebDriver driver;

    public LoginPage() {
        this.driver = BaseTest.getDriver();
    }

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitButton = By.xpath("//input[contains(@type,'submit')]");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(submitButton).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public void checkTitleAfterLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("My View - MantisBT"));

        String pageTitle = driver.getTitle();
        Assert.assertEquals("My View - MantisBT", pageTitle);
    }
}
