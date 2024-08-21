Feature: Mantis Tests
  
  Background:
    Given that I am logged in
  
  @createTask
  Scenario: Create task
    When I click on Create task
    And fill in the task fields
    When I click Create New Task
    Then a task must be created successfully

  @addNote
  Scenario: Add annotation
    When I insert a note
    When I click on Add annotation
    Then the note must appear in the Activities field

  @exportCSV
  Scenario: Export CSV
    When I click on view tasks
    When I click on export CSV
    Then the CSV file should be exported successfully

  @filterTask
  Scenario: Filter task
    When I click on view tasks to filter a task
    When I enter the number of a task 
    And I click on apply filter
    Then should filter only the task number I entered
