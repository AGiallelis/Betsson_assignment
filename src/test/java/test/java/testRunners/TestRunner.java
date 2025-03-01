package test.java.testRunners;  // Adjust to your package structure

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources", // Path to your feature files
        glue = "test/java/stepDefinition", // Path to your step definition classes
        plugin = {
                "pretty", // Pretty output in the console
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json" // JSON report for CI/CD
        },
        monochrome = true, // Ensures the output is more readable in the console
        tags = "@smokeTest" // Optional: Use this to run tests with specific tags
)
public class TestRunner extends AbstractTestNGCucumberTests {

    // This method allows TestNG to provide the feature files to the Cucumber test runner
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios(); // This method enables parallel execution
    }
}