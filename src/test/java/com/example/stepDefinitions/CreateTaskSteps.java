package com.example.stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.example.pages.CreateTaskPage;

public class CreateTaskSteps {
    
    private CreateTaskPage createTaskPage = new CreateTaskPage();

    @When("I click on Create task")
    public void i_click_on_create_task() {
        createTaskPage.clickCreateTask();
    }

    @When("fill in the task fields")
    public void fill_in_the_task_fields() {
        createTaskPage.fillInFields();
    }

    @When("I click Create New Task")
    public void i_click_create_new_task() {
        createTaskPage.clickCreateNewTask();
    }

    @Then("a task must be created successfully")
    public void a_task_must_be_created_successfully() {
        createTaskPage.createTaskSuccessMessage();    
    }
}
