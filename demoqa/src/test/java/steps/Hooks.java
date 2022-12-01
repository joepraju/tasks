package steps;

import base.DriverConfig;
import io.cucumber.core.gherkin.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks extends DriverConfig {

    @Before
    public void beforeScenario() {
        System.out.println("This will run before the Scenario");
    }

    @After
    public void before_or_after(io.cucumber.java.Scenario sc) {
        System.out.println("This will run after the Scenario");

        if (sc.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            sc.embed(screenshot, "image/png", "Screenshot");
        } else {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            sc.embed(screenshot, "image/png", "Screenshot");
        }
    }

}
