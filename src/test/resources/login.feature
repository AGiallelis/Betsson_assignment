Feature: Login Feature
  Scenario Login001: Login with Incorrect Username and Correct Password
  Given Navigate to the login page
  When the user Enter "standard_user" in the username field
  And the user Enter "secret_sauce" in the password field
  Then the user clicks the "Login" button


