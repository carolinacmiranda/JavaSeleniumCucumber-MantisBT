package com.example.pages;

import org.junit.Assert;
import java.time.Duration;
import com.example.hooks.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNotePage {

    private WebDriver driver;

    public AddNotePage() {
        this.driver = BaseTest.getDriver();
    }

    private By clickLastTask = By.xpath("(//a[contains(.,'Test Summary')])[1]");
    private By addNoteField = By.id("bugnote_text");
    private By clickAddNoteButton = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");
    private By addedAnnotation = By.xpath("//td[@class='bugnote-note bugnote-public'][contains(.,'Adding a note')]");

    public void addNoteField() {
        driver.findElement(clickLastTask).click();
        driver.findElement(addNoteField).sendKeys("Adding a note");
    }

    public void clickAddNoteButton() {
        driver.findElement(clickAddNoteButton).click();
    }

    public void addNoteSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(addedAnnotation, "Adding a note"));
        String actualText = driver.findElement(addedAnnotation).getText();
        Assert.assertEquals("Adding a note", actualText);
    }
}
