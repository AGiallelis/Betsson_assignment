package stepDefinition;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;

public class AppPerformanceSteps {
    private static AndroidDriver driver;

    @Given("Add a large number of products to the cart")
    public void addLargeNumberOfProductsToCart() throws MalformedURLException {
        setup();
        for (int i = 0; i < 20; i++) { // Adjust count as needed
            MobileElement product = driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Add to Cart')]")).click();
        }
    }

    @Then("Tap on the cart icon")
    public void tapOnCartIcon() {
        MobileElement cartIcon = (MobileElement) driver.findElement(By.id("cart_icon_id")); // Replace with actual ID
        cartIcon.click();
    }

    @Given("Put the mobile device in a low signal area or use a slow internet connection")
    public void slowNetworkSimulation() {
        // This step is usually done manually or via network throttling tools
        System.out.println("Ensure network is slow for testing.");
    }

    @Then("Browse products or complete checkout")
    public void browseOrCheckout() {
        try {
            MobileElement product = driver.findElement(By.id("product_list_id")); // Replace with actual ID
            Assert.assertNotNull(product, "Product list should be visible.");
        } catch (Exception e) {
            Assert.fail("Failed to load products under slow network");
        }
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
