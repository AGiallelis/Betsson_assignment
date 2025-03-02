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

class InstallationAndLaunch {
    private static AndroidDriver driver;

    @Given("Install the app from the respective app store \\(Google Play for Android, App Store for iOS\\)")
    public void installAppFromStore() {
        System.out.println("Ensure the app is installed from the respective store.");
    }

    @Then("Open the app for the first time")
    public void openAppForFirstTime() {
        setup();
        System.out.println("Launching the app for the first time.");
    }

    @Given("Install the app")
    public void installApp() {
        System.out.println("Ensure the app is installed on the device.");
    }

    @When("Update the app through the app store")
    public void updateApp() {
        System.out.println("Updating the app through the store.");
    }

    @Then("Launch the app after the update")
    public void launchAppAfterUpdate() {
        setup();
        System.out.println("Launching the app after updating.");
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
