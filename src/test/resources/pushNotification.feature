Feature: Push Notification Feature
  Scenario pushNotification001: Push Notification on New Offers/Updates
    Given Enable push notifications for the app
    Then Wait for a push notification (e.g., new offer, update)
  Scenario pushNotification002: Handling of Notification Taps
    Given Receive a push notification about a product offer
    Then Tap the notification