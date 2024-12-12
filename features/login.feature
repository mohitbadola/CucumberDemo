Feature: User Login

  Scenario: Successful Login
    Given the user is on the opencart login page.
    When the user enters valid credentials (username: "kaukau@gmail.com", password: "kaukau@123")
    And the user clicks on the Login button
    Then the user should be redirected to the Account Page
    And the user should see My Account

