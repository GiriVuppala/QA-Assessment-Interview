package stepDefs;

import com.sun.tools.xjc.reader.gbind.ElementSets;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import io.restassured.specification.RequestSpecification;
import utils.Request;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityBikeStepDefs extends Request{

    @Given("As a user I prepare the {string} request body")
    public void asAUserIPrepareTheRequestBody(String requestType) {

        if (requestType.equals("GET"))
        {
            GETRequestBody();
        }


    }

    @When("I trigger the endpoint")
    public void iTriggerTheEndpoint() {

        getResponse();
    }

    @Then("validate {int} response code")
    public void validateResponseCode(int responseCode) {

        verifyResponseCode(responseCode);
    }


    @And("validate the response with {string} and {string} and Verify {string} and {string}")
    public void validateTheResponseWithAndAndVerifyAnd(String country, String city, String latitude, String longitude) {

        verifyResponseData(country,city,latitude,longitude);

    }


    @And("validate the invalid response with {string} and {string} and Verify {string} and {string}")
    public void validateTheInvalidResponseWithAndAndVerifyAnd(String country, String city, String latitude, String longitude) {

        verifyInvalidResponseData(country,city,latitude,longitude);
    }
}
