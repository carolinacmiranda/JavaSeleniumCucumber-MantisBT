package com.example.stepDefinitions;

import com.example.pages.ExportCSVPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExportCSVSteps {

    private ExportCSVPage exportCSVPage = new ExportCSVPage();
    
    @When("I click on view tasks")
    public void i_click_on_view_tasks() {
        exportCSVPage.clickViewTasks();
    }

    @When("I click on export CSV")
    public void i_click_on_export_csv() {
        exportCSVPage.clickExportCSV();
    }

    @Then("the CSV file should be exported successfully")
    public void the_csv_file_should_be_exported_successfully() {
        exportCSVPage.checkDownloadedFile();
    }
}
