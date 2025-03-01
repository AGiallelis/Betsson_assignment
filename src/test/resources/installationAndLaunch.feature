Feature: Installation and Launch Feature
  Scenario installationLaunch001: Install and Launch the App(First Time)
    Given Install the app from the respective app store (Google Play for Android, App Store for iOS)
    Then Open the app for the first time
  Scenario installationLaunch002: App Launch After Updates
    Given Install the app
    When Update the app through the app store
    Then Launch the app after the update
