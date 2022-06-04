@allsteps
Feature: Indiser Web Page

  @step1
  Scenario: Open web page
    Given the user enters the web page
    Then the web page title should seen "Insider personalization engine for seamless customer experiences"

  @step2
  Scenario: Verify the titles under the "Career" module
    Given the user enters the web page
    Then the user navigates to "More" button
    And the user able to click "Careers"
    When the user verify to "Find your calling", "25 offices across 5 continents, home to 600+ Insiders" and "We’re here to grow and drive growth—as none of us did before." blocks

@step3
  Scenario: Check presence of jobs list
    Given the user enters the web page
    Then the user navigates to "More" button
    And the user able to click "Careers"
    And the user clicks the "See all teams" button
    And the user selects "Quality Assurance"
    And the user clicks to "See all QA jobs" button
    When the user chooses "Istanbul, Turkey" filter by Location
    Then the user should be able to see presence of "Quality Assurance" jobs list
  Then the user clicks "Software Quality Assurance Analyst" Apply Now button and see application page

  ## Scenario Outline: Different user types
  #    Given the user logged in as "<userType>"
  #
  #    Examples:
  #      | userType      |
  #      | driver        |
  #      | admin         |



