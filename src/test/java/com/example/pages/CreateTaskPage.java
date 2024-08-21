package com.example.pages;

import org.junit.Assert;
import java.time.Duration;
import com.example.hooks.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateTaskPage {

    private WebDriver driver;

    public CreateTaskPage() {
        this.driver = BaseTest.getDriver();
    }

    private By createTaskButton = By.xpath("//a[@class='btn btn-primary btn-sm']");
    private By categorySelect = By.id("category_id");
    private By summary = By.id("summary");
    private By description = By.id("description");
    private By createNewTaskButton = By.xpath("//input[@type='submit']");

    public void clickCreateTask() {
        driver.findElement(createTaskButton).click();
    }

    public void fillInFields() {
        WebElement selectElement = driver.findElement(categorySelect);
        Select categoryDropdown = new Select(selectElement);
        categoryDropdown.selectByValue("1");
        driver.findElement(summary).sendKeys("Test Summary");
        driver.findElement(description).sendKeys("Test Description");
    }

    public void clickCreateNewTask() {
        driver.findElement(createNewTaskButton).click();
    }

    public void createTaskSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Test Summary"));

        String pageTitle = driver.getTitle();
        Assert.assertTrue("Test Summary", pageTitle.contains("Test Summary"));
    }
}
