Feature: App Permissions Feature
  Scenario appPermission001: App Permissions (Location, Camera, Storage)
    Given Open the app for the first time and grant/deny permissions for location, camera, and storage
    Then Verify that the app behaves as expected based on the permission granted (e.g., location-based features won't work if location is denied)

