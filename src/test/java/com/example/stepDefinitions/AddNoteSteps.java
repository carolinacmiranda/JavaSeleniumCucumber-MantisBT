package com.example.stepDefinitions;

import com.example.pages.AddNotePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNoteSteps {

    private AddNotePage addNotePage = new AddNotePage();

    @When("I insert a note")
    public void i_insert_a_note() {
        addNotePage.addNoteField();
    }

    @When("I click on Add annotation")
    public void i_click_on_add_annotation() {
        addNotePage.clickAddNoteButton();
    }

    @Then("the note must appear in the Activities field")
    public void the_note_must_appear_in_the_activities_field() {
        addNotePage.addNoteSuccess();
    }
}
