package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Test Runner configuration
 *
 * Created by Prashanth Raju
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features/"},
        glue = {"steps"},
        monochrome = true,
        plugin = {"pretty", "html:target/HTMLReports"},
        strict = true

)
public class TestRunner {
}
