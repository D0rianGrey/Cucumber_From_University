Feature: Login Functionality
  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully

  Scenario: Login Successful

    Given I am in the login page of the Para Bank Application
    When I enter valid credentials
    Then I should be taken to the Secure Area page

  Scenario Outline: Login Successful v2

    Given I am in the login page of the Para Bank Application
    When I enter valid <username> and <password>
    Then I should be taken to the Secure Area page
    Examples:
      | username      | password   |
      | "autotester"  | "password" |
      | "autotestest" | "password" |

  Scenario: Login Successful v3 (data table)

    Given I am in the login page of the Para Bank Application
    When I enter valid credentials data table
    |autoteater|password|
    Then I should be taken to the Secure Area page