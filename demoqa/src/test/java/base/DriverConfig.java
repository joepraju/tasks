package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Initialize the driver
 *
 * Created by Prashanth Raju
 *
 */
public class DriverConfig {

    public WebDriver driver;
    public DriverConfig() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}