package stepDefinition;

import Betsson.AppiumSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import static org.testng.Assert.assertTrue;

public class StepDefinitions {

    private Object AppiumSetup;

    @Given("I launch the mobile app")
    public void i_launch_the_mobile_app() throws InterruptedException {
        AppiumSetup.wait();
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
       AppiumSetup.driver.findElement(By.id("com.example.android:id/loginButton")).click();
    }

    @Then("I should see the home screen")
    public void i_should_see_the_home_screen() {
       assertTrue(AppiumSetup.driver.findElement(By.id("com.example.android:id/homeScreen")).isDisplayed());
    }
}