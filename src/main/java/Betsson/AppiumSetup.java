package Betsson; // Adjust to your package structure

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;

public class AppiumSetup {

    public static AppiumDriver driver;

    // Method to initialize Appium Driver with desired capabilities for Android (change for iOS as needed)
    public static AppiumDriver initializeAppium() throws Exception {
        // Set Desired Capabilities for the Android app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); // Set the platform (Android or iOS)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RFCT3161VCV "); // Change to your device name
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13"); // Your Android version (e.g., 10.0)
        capabilities.setCapability(MobileCapabilityType.APP, "/Εσωτερικός χώρος αποθήκευσης/Download/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk"); // Path to your APK file
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true); // Don't reset app state between sessions
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false); // Do not reset app every time

        // Additional capabilities as needed
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp"); // Your app's package name
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity"); // Your app's main activity

        // Optional: Set up ChromeDriver for running browser-based tests on the device (if necessary)
        capabilities.setCapability("chromedriverExecutable", "/path/to/chromedriver"); // Path to chromedriver (optional, for web view testing)

        // Start the Appium server
        // Replace the URL below with the appropriate Appium server URL if running locally or on a grid
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        System.out.println("Connection successful!");
        return driver;
    }

    // Method to stop the Appium Driver session
    public static void stopAppium() {
        if (driver != null) {
            driver.quit(); // Close the app and stop the driver session
        }
    }

    // Utility method to find elements using By (returns WebElement)
    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Utility method to click an element
    public static void clickElement(By locator) {
        WebElement element = findElement(locator);
        if (element != null) {
            element.click();
        }
    }

    // Utility method to send text to an input field
    public static void sendKeysToElement(By locator, String text) {
        WebElement element = findElement(locator);
        if (element != null) {
            element.sendKeys(text);
        }
    }
}
