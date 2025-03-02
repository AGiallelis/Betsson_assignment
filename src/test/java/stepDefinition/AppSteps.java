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

    @Given("navigate to the login page")
    public void navigateToLoginPage() {
        WebElement loginPage = driver.findElement(By.id("login_page_id")); // Replace with actual ID
        loginPage.click();
    }

    @When("the user enter \"(.*)\" in the username field")
    public void enterUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("username_field_id")); // Replace with actual ID
        usernameField.sendKeys(username);
    }

    @When("the user enter \"(.*)\" in the password field")
    @When("Enter a valid password \\(e.g., \"secret_sauce\"\\)")
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password_field_id")); // Replace with actual ID
        passwordField.sendKeys(password);
    }

    @Then("the user clicks the \"Login\" button")
    @Then("Click the \"Login\" button")
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login_button_id")); // Replace with actual ID
        loginButton.click();
    }

    @When("leave both the username and password fields empty")
    @Given("leave the username and password fields empty")
    public void leaveFieldsEmpty() {
        WebElement usernameField = driver.findElement(By.id("username_field_id")); // Replace with actual ID
        usernameField.clear();
        WebElement passwordField = driver.findElement(By.id("password_field_id")); // Replace with actual ID
        passwordField.clear();
    }

    @Given("Enter a username with special characters \\(e.g., \"user!@#\"\\)")
    public void enterSpecialCharacterUsername() {
        WebElement usernameField = driver.findElement(By.id("username_field_id")); // Replace with actual ID
        usernameField.sendKeys("user!@#");
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
