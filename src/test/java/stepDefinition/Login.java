package stepDefinition;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.cucumber.spring.SpringFactory;
import java.net.MalformedURLException;
import java.net.URL;

public class Login {
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

    private void setup() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "RFCT3161VCV");
                caps.setCapability("appPackage", "com.swaglabsmobileapp"); // Replace with actual app package
                caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity"); // Replace with actual activity
                caps.setCapability("automationName", "UiAutomator2");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
                System.out.println("Connection successful!");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                System.out.println("Connection unsuccessful!");
            }
        }
    }
}
