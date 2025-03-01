Feature: App Performance Feature
  Scenario appPerformance001: App Performance Under Heavy Load (Multiple Products in Cart)
    Given Add a large number of products to the cart
    Then Tap on the cart icon
  Scenario appPerformance002: App Performance with Slow Network
    Given Put the mobile device in a low signal area or use a slow internet connection
    Then Browse products or complete checkout
