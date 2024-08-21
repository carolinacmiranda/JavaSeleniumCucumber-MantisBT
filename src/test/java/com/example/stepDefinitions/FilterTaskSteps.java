package com.example.stepDefinitions;

import com.example.pages.ExportCSVPage;
import com.example.pages.FilterTaskPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterTaskSteps {

    private ExportCSVPage exportCSVPage = new ExportCSVPage();
    private FilterTaskPage filterTaskPage = new FilterTaskPage();
    
    @When("I click on view tasks to filter a task")
    public void i_click_on_view_tasks_to_filter_a_task() {
        exportCSVPage.clickViewTasks();
    }

    @When("I enter the number of a task")
    public void i_enter_the_number_of_a_task() {
        filterTaskPage.filterTask();
    }

    @When("I click on apply filter")
    public void i_click_on_apply_filter() {
        filterTaskPage.clickFilter();
    }

    @Then("should filter only the task number I entered")
    public void should_filter_only_the_task_number_i_entered() {
        filterTaskPage.checkFilterTask();
    }
}
