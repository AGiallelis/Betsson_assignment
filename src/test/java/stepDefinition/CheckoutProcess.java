package stepDefinition;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckoutProcessSteps {
    private static AndroidDriver driver;

    @Given("Navigate to the cart page")
    public void navigateToCartPage() {
        WebElement cartIcon = driver.findElement(By.id("cart_icon_id")); // Replace with actual ID
        cartIcon.click();
    }

    @Then("Click the \"Checkout\" button")
    @When("Tap the \"Checkout\" button")
    public void clickCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.id("checkout_button_id")); // Replace with actual ID
        checkoutButton.click();
    }

    @Then("Enter valid payment and shipping information")
    @When("Proceed to checkout and enter valid payment and shipping information")
    public void enterValidPaymentAndShippingInfo() {
        WebElement paymentField = driver.findElement(By.id("payment_field_id")); // Replace with actual ID
        paymentField.sendKeys("Valid Payment Info");
        WebElement shippingField = driver.findElement(By.id("shipping_field_id")); // Replace with actual ID
        shippingField.sendKeys("Valid Shipping Info");
    }

    @When("Confirm and complete the order")
    @Then("Tap the \"Confirm Order\" button")
    @Then("Attempt to complete the order")
    public void confirmAndCompleteOrder() {
        WebElement confirmOrderButton = driver.findElement(By.id("confirm_order_button_id")); // Replace with actual ID
        confirmOrderButton.click();
    }

    @When("Leave payment information fields empty")
    public void leavePaymentInfoEmpty() {
        WebElement paymentField = driver.findElement(By.id("payment_field_id")); // Replace with actual ID
        paymentField.clear();
    }

    @When("Leave shipping information \(e.g., address, city\) empty")
    public void leaveShippingInfoEmpty() {
        WebElement shippingField = driver.findElement(By.id("shipping_field_id")); // Replace with actual ID
        shippingField.clear();
    }

    @Then("Click the \"Continue\" button")
    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.id("continue_button_id")); // Replace with actual ID
        continueButton.click();
    }

    @Given("Enter invalid payment information \(e.g., an expired card number or an invalid CVV\).")
    public void enterInvalidPaymentInfo() {
        WebElement paymentField = driver.findElement(By.id("payment_field_id")); // Replace with actual ID
        paymentField.sendKeys("Invalid Payment Info");
    }

    @Given("Proceed to the checkout screen with items in the cart")
    public void proceedToCheckoutScreen() {
        navigateToCartPage();
        clickCheckoutButton();
    }

    @When("Enter incomplete billing information \(e.g., missing zip code or incomplete card details\).")
    public void enterIncompleteBillingInfo() {
        WebElement billingField = driver.findElement(By.id("billing_field_id")); // Replace with actual ID
        billingField.sendKeys("Incomplete Billing Info");
    }

    @Given("User has added products to the cart")
    @Given("User has items in the cart")
    public void userHasItemsInCart() {
        navigateToCartPage();
    }

    private void setup() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "emulator-5554");
            caps.setCapability("appPackage", "com.example.app"); // Replace with actual app package
            caps.setCapability("appActivity", "com.example.app.MainActivity"); // Replace with actual activity
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }
    }
}
