# new feature
# Tags: optional
    
Feature: Testing PHP travels
    @smoke
Scenario: Exercise One
    Given I am on the PHP travels homepage
    When I click sign up
    And I fill out the information
    And I submit the form

  Scenario: Exercise Two
    Given I am on the PHP travels homepage
    When I log in
    Then I will be on the profile page

  Scenario: Exercise Three
    Given I am on the PHP travels homepage
    When I click book now on one of the guided tours
    And I fill in the info and click book
    And I fill in the personal details page and submit
    Then I will be on the invoice page

  Scenario: Exercise Four
    Given I am on the PHP travels homepage
    When I click on the flights button
    And I Search for a flight
    And I click on book now
    And I fill in the personal details page and submit
    Then I will be on the invoice page

  Scenario: Exercise Five
    Given I am on the PHP travels homepage
    When I click book now on a hotel
    And I enter date values
    And I click to book the hotel
    And I fill in the personal details page and submit
    Then I will be on the invoice page
    Then the dates will be correct

  Scenario: Exercise Six
    Given I am on the PHP travels homepage
    When I click log in
    And I enter invalid information
    Then an error message will be shown
