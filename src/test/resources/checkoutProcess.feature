Feature: Checkout Process Feature
  Scenario CheckoutProcess001: Checkout with Valid Payment Information
    Given Navigate to the cart page
    Then Click the "Checkout" button
    And Enter valid payment and shipping information
    When Confirm and complete the order
  Scenario CheckoutProcess002: Checkout with Missing Payment Information
    Given Navigate to the cart page
    When Click the "Checkout" button
    And Leave payment information fields empty
    Then Try to complete the order
  Scenario CheckoutProcess003: Checkout with Missing Shipping Information
    Given Click the "Checkout" button
    When Leave shipping information (e.g., address, city) empty
    Then Click the "Continue" button
  Scenario CheckoutProcess004: Checkout with Invalid Payment Information
    Given Enter invalid payment information (e.g., an expired card number or an invalid CVV).
    Then Attempt to complete the order
  Scenario CheckoutProcess005: Checkout with Incomplete Billing Information
    Given Proceed to the checkout screen with items in the cart
    When Enter incomplete billing information (e.g., missing zip code or incomplete card details).
    Then Attempt to confirm the order
  Scenario CheckoutProcess006: Proceed to Checkout with Items in Cart
    Given User has added products to the cart
    When Tap the cart icon
    Then Tap the "Checkout" button
  Scenario CheckoutProcess007: Successful Checkout Process
    Given User has items in the cart
    When Tap the cart icon
    And Proceed to checkout and enter valid payment and shipping information
    Then Tap the "Confirm Order" button