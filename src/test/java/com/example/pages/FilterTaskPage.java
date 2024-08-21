package com.example.pages;

import org.junit.Assert;
import com.example.hooks.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FilterTaskPage {

    private WebDriver driver;

    public FilterTaskPage() {
        this.driver = BaseTest.getDriver();
    }

    private By viewTasksButton = By.xpath("//i[contains(@class,'menu-icon fa fa-list-alt')]");
    private By filterField = By.id("filter-search-txt");
    private By filterButton = By.xpath("//input[contains(@name,'filter_submit')]");
    private By filterContains = By.xpath("//span[@class='badge'][contains(.,'1 - 1 / 1')]");

    public void clickViewTasks() {
        driver.findElement(viewTasksButton).click();
    }

    public void filterTask() {
        driver.findElement(filterField).sendKeys("1427");
    }

    public void clickFilter() {
        driver.findElement(filterButton).click();
    }

    public void checkFilterTask() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterContains));
        String actualTasksContains = driver.findElement(filterContains).getText();
        String expectedPart = "1";
        String actualPart = actualTasksContains.split(" ")[0];
        Assert.assertEquals("The filter didn't return the expected value.", expectedPart, actualPart);
    }
}
