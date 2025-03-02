package stepDefinition;

import Betsson.AppiumSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import static org.testng.Assert.assertTrue;

public class StepDefinitions {

    private AppiumSetup appiumSetup;

    @Given("I launch the mobile app")
    public void i_launch_the_mobile_app() throws InterruptedException {
        appiumSetup = new AppiumSetup();  // Initialize AppiumSetup
        appiumSetup.wait();  // Call wait() method to set up the app
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        appiumSetup.driver.findElement(By.id("com.example.android:id/loginButton")).click();  // Interact with the app
    }

    @Then("I should see the home screen")
    public void i_should_see_the_home_screen() {
        assertTrue(appiumSetup.driver.findElement(By.id("com.example.android:id/homeScreen")).isDisplayed());  // Check if home screen is visible
    }
}