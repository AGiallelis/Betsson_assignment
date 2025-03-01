Feature: Sorting and Filtering Products Feature
  Scenario SortingFilteringProducts001: Sort Products by Price (Low to High)
    Given navigate to the product page
    Then select the "Price (low to high)" option from the sorting dropdown
  Scenario SortingFilteringProducts002: Sort Products by Price (High to Low)
    Given navigate to the product page
    Then select the "Price (high to low)" option from the sorting dropdown