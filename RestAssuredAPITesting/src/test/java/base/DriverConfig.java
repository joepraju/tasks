package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverConfig {

    public WebDriver driver;
    public DriverConfig() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}