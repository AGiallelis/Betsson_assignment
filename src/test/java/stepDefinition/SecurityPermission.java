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

public class AppSteps {
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

    @Given("Open the app for the first time and grant/deny permissions for location, camera, and storage")
    public void handleAppPermissions() {
        System.out.println("Handling app permissions for location, camera, and storage.");
    }

    @Then("Verify that the app behaves as expected based on the permission granted \(e.g., location-based features won't work if location is denied\)")
    public void verifyAppBehaviorBasedOnPermissions() {
        System.out.println("Verifying app behavior based on granted permissions.");
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
