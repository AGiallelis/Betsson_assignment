Feature: Invalid Login Feature
  Scenario InvalidLogin001: Invalid Login login - Incorrect Username
    Given navigate to the login page
    When the user enter "wrong_user" in the username field
    And the user enter "secret_sauce" in the password field
    Then the user clicks the "Login" button
  Scenario InvalidLogin002: Invalid Login login - Incorrect Password
    Given navigate to the login page
    When the user enter "standard_user" in the username field
    And the user enter "wrong_password" in the password field
    Then the user clicks the "Login" button
  Scenario InvalidLogin003: Invalid Login login - Empty Fields
    Given navigate to the login page
    When leave both the username and password fields empty
    Then the user clicks the "Login" button
  Scenario InvalidLogin004: Login with Empty Username and Password
    Given leave the username and password fields empty
    Then the user clicks the "Login" button
  Scenario InvalidLogin005:  Login with Special Characters in Username
    Given Enter a username with special characters (e.g., "user!@#")
    When Enter a valid password (e.g., "secret_sauce")
    Then Click the "Login" button