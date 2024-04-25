package stepdef;

import base.BaseBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import utilities.GlobalConstant;
import utilities.Utils;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class GetAllMovies {

    public RequestSpecification requestSpecification;

    BaseBuilder baseBuilder = new BaseBuilder();

    private Response response;

    String uri = "";
    private JSONObject jsonObject;

    @Given("The endpoint is given for movies")
    public void the_endpoint_is_given_for_movies() {
        uri = "";
    }


    @When("Hit the API for movies")
    public void hit_the_api_for_movies() throws FileNotFoundException {
        requestSpecification = baseBuilder.placeSpecBuilder();
        response = given()
                .spec(requestSpecification)
                .when()
                .log().all()
                .get(GlobalConstant.getAllMovies);

        System.out.println(response.toString());

    }

    @Then("Validate the status code for movies")
    public void validate_the_status_code_for_movies() {
        Utils.verifyStatusCode(response, GlobalConstant.HTTP_UNAUTHORIZED); // Also verifying the status code here
    }

    @Then("Validate for negative Test Case")
    public void validate_for_negative_test_case() throws JSONException {
        jsonObject = Utils.extractJsonObjectFromResponse(response);
        System.out.println(response.asString());
        Utils.assertJsonValueEquals("message", "Unauthorized.", jsonObject);
    }

}

