package zippopotam.com;

import base.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.hamcrest.Matchers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasSize;

/**
 * Validating API using RestAssured
 * Created by Prashanth Raju
 *
 * Property file path : src/test/resources/properties/Configuration.properties
 * Report path : test-output/testReport.html
 * Run command : mvn clean test
 */

public class TestCase extends ConfigFileReader {
    ConfigFileReader fileReader = new ConfigFileReader();
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    //Generate the logs in the test report.
    ExtentTest test;
    RequestSpecification httpRequest;
    Response response;
    JsonPath js;
    // Read the attributes from the configuration file
    String url= fileReader.getAttrValue("url").replace("\"", "");
    String countryCode = fileReader.getAttrValue("countryCodeGB").replace("\"", "");
    String wrongCountryCode = fileReader.getAttrValue("wrongCountryCode").replace("\"", "");
    String postalCode = fileReader.getAttrValue("postalCodeAB1").replace("\"", "");
    String getPostalCodeGU22 = fileReader.getAttrValue("getPostalCodeGU22").replace("\"", "");



    @BeforeTest
    public void startReport() {
        //System.out.println(url + countryCode + postalCode);
        //Initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
        //Initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Report configuration
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("dd MMMM yyyy, hh:mm a '('zzz')'");

     }

    @Test
    public void TC_001() throws URISyntaxException {
        test = extent.createTest("Test Case_001", "GIVEN I am searching for a postcode\n" +
                "WHEN I make a valid request\n" +
                "THEN the request contains the following fields and types\n" +
                "\n" +
                "post code -> string\n" +
                "country -> string\n" +
                "country abbreviation -> string\n" +
                "places -> array");

        RestAssured.baseURI=url;
        httpRequest =
                RestAssured.given();
        response = httpRequest.request(Method.GET,countryCode +"/" +postalCode);
        js = response.jsonPath();

        test.log(Status.INFO,"Post Code type : "  + js.get("'post code'").getClass().getSimpleName());
        test.log(Status.INFO,"Country type : "  + js.get("country").getClass().getSimpleName());
        test.log(Status.INFO,"Country abbreviation type : "  + js.get("'country abbreviation'").getClass().getSimpleName());

        Object testPlaces = RestAssured.get("http://api.zippopotam.us/GB/GU22")
                .then()
                .body("places", Matchers.instanceOf(List.class));
        if(testPlaces.toString() != null){
            test.log(Status.INFO,"Places type : Array" );
        }
    }


    @Test
    public void TC_002() {
        test = extent.createTest("Test Case_002", "GIVEN I am searching for a postcode\n" +
                "        WHEN I make a valid request\n" +
                "        THEN the post code returned in the response matches the postcode I pass as a request parameter");

        response = httpRequest.request(Method.GET,countryCode +"/" + getPostalCodeGU22);
        js = response.jsonPath();
        try {
            Assert.assertEquals(js.get("'post code'"), getPostalCodeGU22);
            test.log(Status.INFO,"Post Code : " +getPostalCodeGU22 +" ; API response post code is : "  + js.get("'post code'"));
        } catch (AssertionError e) {
            test.log(Status.INFO,"Post Code : " +getPostalCodeGU22 +" ; API response post code is : "  + js.get("'post code'"));
            test.log(Status.INFO,response.prettyPrint());
            System.out.println("Response not matches with the request parameter");
            throw e;
        }
    }

    @Test
    public void TC_003() {
        test = extent.createTest("Test Case_003", "GIVEN I am searching for a postcode\n" +
                "        WHEN I use the wrong country code\n" +
                "        THEN no data is returned and I receive a 404 error");

        RestAssured.baseURI=url;
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET,wrongCountryCode+ "/" +postalCode);
        try {
            Assert.assertEquals(404,response.statusCode());
            test.log(Status.INFO,"Country code used is : " + wrongCountryCode + " and the Response status code is : " +response.statusCode());
        } catch (AssertionError e) {
            System.out.println("Response code is not 404  and the returned code is : " +response.statusCode());
            throw e;
        }
        System.out.println("Status code in the response is : "+response.statusCode());
    }


    @Test
    public void TC_004() throws URISyntaxException {

        test = extent.createTest("Test Case 004 ", "GIVEN I searching for a postcode\n" +
                "        \nWHEN I search for ‘GU22’ for Great Britain\n" +
                "        THEN 4 places are returned\n" +
                "        AND they are all in the state of England\n" +
                "        AND each one has a place name, longitude, state, state abbreviation and latitude");

        given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI(url+"/"+countryCode+"/"+getPostalCodeGU22))
                .then()
                .body("places.state", hasSize(4))
                .extract();
        //test.log(Status.INFO,"Country code used is : " + wrongCountryCode + " and the Response status code is : " +response.statusCode());

        given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI(url+"/"+countryCode+"/"+getPostalCodeGU22))
                .then()
                .body("places.state", hasItem("England"));

        given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI(url+"/"+countryCode+"/"+getPostalCodeGU22))
                .then()
                .body("places.'place name'", notNullValue(),
                        "places.longitude", notNullValue(),
                        "places.state", notNullValue(),
                        "places.'state abbreviation'", notNullValue(),
                        "places.latitude", notNullValue());
    }


    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,result.getThrowable().getMessage());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Status: PASS");
            //test.log(Status.SKIP, result.getTestName());
        }
        else {
            test.log(Status.SKIP, "Status: SKIPPED");
        }
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }
}