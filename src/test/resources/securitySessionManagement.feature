Feature: Security and Session Management Feature
  Scenario securitySessionManagement001: Session Timeout After Inactivity
    Given Log in to the website
    When Leave the site idle for the expected session timeout duration (e.g., 15 minutes)
    Then Try performing an action after timeout (e.g., add a product to the cart)
