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

public class ProductPage {
    private static AndroidDriver driver;

    @Given("Navigate to the login page")
    public void navigateToLoginPage() {
        WebElement loginPage = driver.findElement(By.id("login_page_id")); // Replace with actual ID
        loginPage.click();
    }

    @When("the user Enter \"(.*)\" in the username field")
    public void enterUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("username_field_id")); // Replace with actual ID
        usernameField.sendKeys(username);
    }

    @When("the user Enter \"(.*)\" in the password field")
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password_field_id")); // Replace with actual ID
        passwordField.sendKeys(password);
    }

    @Then("the user clicks the \"Login\" button")
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login_button_id")); // Replace with actual ID
        loginButton.click();
    }

    @Given("Navigate to the top-right menu")
    public void navigateToTopRightMenu() {
        WebElement menuButton = driver.findElement(By.id("menu_button_id")); // Replace with actual ID
        menuButton.click();
    }

    @Then("Click the \"Logout\" button")
    public void clickLogoutButton() {
        WebElement logoutButton = driver.findElement(By.id("logout_button_id")); // Replace with actual ID
        logoutButton.click();
    }

    @Given("From the home screen \\(product list\\), tap on the \"Cart\" icon")
    public void tapOnCartIcon() {
        WebElement cartIcon = driver.findElement(By.id("cart_icon_id")); // Replace with actual ID
        cartIcon.click();
    }

    @Then("Tap on the \"Back\" button to return to the product list")
    public void tapOnBackButton() {
        WebElement backButton = driver.findElement(By.id("back_button_id")); // Replace with actual ID
        backButton.click();
    }

    @Given("Open the app on a large phone or tablet")
    public void openAppOnLargeDevice() {
        System.out.println("Test case for responsive design on a large device.");
    }

    @Then("Navigate through the product list and other screens")
    public void navigateThroughScreens() {
        System.out.println("Navigating through product list and other screens.");
    }

    @Given("Log in with valid credentials")
    public void loginWithValidCredentials() {
        enterUsername("valid_user");
        enterPassword("valid_password");
        clickLoginButton();
    }

    @Then("Navigate to the product page")
    public void navigateToProductPage() {
        WebElement productPage = driver.findElement(By.id("product_page_id")); // Replace with actual ID
        productPage.click();
    }

    @When("Click the \"Add to Cart\" icon next to a product")
    public void clickAddToCart() {
        WebElement addToCart = driver.findElement(By.id("add_to_cart_id")); // Replace with actual ID
        addToCart.click();
    }

    @Then("Observe the cart icon or notification")
    public void observeCartIcon() {
        System.out.println("Cart icon or notification should be updated.");
    }

    @Given("Navigate to the shopping cart page")
    public void navigateToShoppingCart() {
        WebElement cartPage = driver.findElement(By.id("cart_page_id")); // Replace with actual ID
        cartPage.click();
    }

    @Then("Click the \"Remove\" button next to a product in the cart")
    public void clickRemoveButton() {
        WebElement removeButton = driver.findElement(By.id("remove_button_id")); // Replace with actual ID
        removeButton.click();
    }

    @Given("Select a product that has limited stock")
    public void selectLimitedStockProduct() {
        WebElement limitedStockProduct = driver.findElement(By.id("limited_stock_product_id")); // Replace with actual ID
        limitedStockProduct.click();
    }

    @Then("Try adding a number of items to the cart greater than the available stock")
    public void addMoreThanAvailableStock() {
        System.out.println("Attempting to add more items than available stock.");
    }

    @Given("Click on the cart icon")
    public void clickCartIcon() {
        tapOnCartIcon();
    }

    @Then("Attempt to proceed to the checkout page")
    public void attemptCheckout() {
        WebElement checkoutButton = driver.findElement(By.id("checkout_button_id")); // Replace with actual ID
        checkoutButton.click();
    }

    @Given("Tap on a product from the list")
    public void tapOnProduct() {
        WebElement product = driver.findElement(By.id("product_item_id")); // Replace with actual ID
        product.click();
    }

    @Then("Verify that the product details page displays the correct name, description, price, and image")
    public void verifyProductDetails() {
        System.out.println("Checking product details page for correct information.");
    }

    private void setup() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "emulator-5554");
                caps.setCapability("appPackage", "com.example.app"); // Replace with actual app package
                caps.setCapability("appActivity", "com.example.app.MainActivity"); // Replace with actual activity
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
}
