package com.example.pages;

import java.io.IOException;
import java.nio.file.*;
import org.junit.Assert;
import com.example.hooks.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.time.Instant;

public class ExportCSVPage {

    private WebDriver driver;
    private String downloadedFile;

    public ExportCSVPage() {
        this.driver = BaseTest.getDriver();
        this.downloadedFile = System.getProperty("user.home") + "/Downloads";
    }

    private By viewTasksButton = By.xpath("//i[contains(@class,'menu-icon fa fa-list-alt')]");
    private By exportCSVButton = By.xpath("//a[@href='csv_export.php']");

    public void clickViewTasks() {
        driver.findElement(viewTasksButton).click();
    }

    public void clickExportCSV() {
        driver.findElement(exportCSVButton).click();
    }

    public void checkDownloadedFile() {
        String expectedFileName = "Carolina_Costa´s_Project.csv";
        Path downloadPath = Paths.get(downloadedFile, expectedFileName);
        boolean fileExists = waitForFileDownload(downloadPath, 30);
        Assert.assertTrue("CSV file doesn't exist.", fileExists);
        deleteDownloadedFile(downloadPath);
    }

    private boolean waitForFileDownload(Path filePath, int timeoutInSeconds) {
        Instant end = Instant.now().plus(Duration.ofSeconds(timeoutInSeconds));

        while (Instant.now().isBefore(end)) {
            if (Files.exists(filePath)) {
                return true;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private void deleteDownloadedFile(Path filePath) {
        try {
            Files.deleteIfExists(filePath);
            System.out.println("Arquivo deletado: " + filePath.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Falha ao deletar o arquivo: " + filePath.getFileName());
        }
    }
}
