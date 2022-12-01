package steps;
import base.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import java.util.concurrent.TimeUnit;
import static org.apache.commons.lang.StringUtils.trim;

/**
 * Fill and submit the form on the demoqa.com
 *
 * Created by Prashanth Raju
 *
 * Feature file path : /features
 * Property file path : /src/test/resources/properties/Configuration.properties
 * Report path : /target/HTMLReports/index.html
 * Run command : mvn clean test
 */


public class FormSubmit  extends DriverConfig{

    WebElement radioMale;
    WebElement submitBtn;
    ConfigFileReader fileReader = new ConfigFileReader();
    By formsHomePage = By.xpath("//*[@id='app']/div/div/div[2]/div/div[2]/div/div[2]");
    By practiceForm = By.xpath("(//*[@id=\"item-0\"]/span)[2]");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By mobile = By.id("userNumber");
    By closeBtn = By.id("closeLargeModal");


    @Given("Open the browser")
    public void open_the_browser() {
        String url = fileReader.getAttrValue("url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @And("Click on Forms")
    public void click_on_Forms() {
        WebElement ele = driver.findElement(formsHomePage);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }

    @And("Click on Practice Form")
    public void click_on_Practice_Form() {
        driver.findElement(practiceForm).click();
    }

    @Given("user enters the First Name, Last Name, Email and Phone number")
    public void user_enters_the_First_Name_Last_Name_Email_and_Phone_number() {
        driver.findElement(firstName).sendKeys(fileReader.getAttrValue("FirstName"));
        driver.findElement(lastName).sendKeys(fileReader.getAttrValue("SecondName"));
        driver.findElement(email).sendKeys(trim(fileReader.getAttrValue("Email")));
        driver.findElement(mobile).sendKeys(fileReader.getAttrValue("Phone"));
        radioMale = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        JavascriptExecutor jseRadioMale = (JavascriptExecutor)driver;
        jseRadioMale.executeScript("arguments[0].click()", radioMale);
    }

    @And("^user enters (.*) and (.*) and (.*)and (.*)$")
    public void user_enters_FirstName_LastName_Email_Phone(String FirstName, String LastName, String Email, String Phone) {
        driver.findElement(firstName).sendKeys(FirstName);
        driver.findElement(lastName).sendKeys(LastName);
        driver.findElement(email).sendKeys(trim(Email));
        driver.findElement(mobile).sendKeys(Phone);
        radioMale = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        JavascriptExecutor jseRadioMale = (JavascriptExecutor)driver;
        jseRadioMale.executeScript("arguments[0].click()", radioMale);
    }


    @When("Click on Submit button")
    public void click_on_Submit_button() {
        submitBtn = driver.findElement(By.id("submit"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", submitBtn);
    }

    @Then("Confirmation window should be displayed")
    public void confirmation_window_should_be_displayed() throws InterruptedException {
        String getConfirmationMsg = driver. findElement(By. xpath("//*[@role='document']/div/div/div")).getText();
        Assert.assertEquals("Thanks for submitting the form",getConfirmationMsg);
        WebElement ele = driver.findElement(closeBtn);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
        driver.close();
        driver.quit();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
