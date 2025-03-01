Feature: Product Page Feature
  Scenario ProductPage001: Product List Display
    Given Log in with valid credentials
    Then Navigate to the product page
  Scenario ProductPage002: Add Product to Cart
    Given Navigate to the product page
    When Click the "Add to Cart" icon next to a product
    Then Observe the cart icon or notification
  Scenario ProductPage003: Remove Product from Cart
    Given Navigate to the shopping cart page
    Then Click the "Remove" button next to a product in the cart
  Scenario ProductPage004: Attempt to Add More Items than Available to Cart
    Given Select a product that has limited stock
    Then Try adding a number of items to the cart greater than the available stock
  Scenario ProductPage005: Empty Cart Checkout
    Given Click on the cart icon
    Then Attempt to proceed to the checkout page
  Scenario ProductPage006: View Product Details
    Given Tap on a product from the list
    Then Verify that the product details page displays the correct name, description, price, and image