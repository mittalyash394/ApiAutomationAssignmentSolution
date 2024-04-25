package stepdef;

import base.BaseBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.GlobalConstant;
import utilities.Utils;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class GetAllMoviesWithHeaders {

    public RequestSpecification requestSpecification;

    BaseBuilder baseBuilder = new BaseBuilder();

    private Response response;

    String uri = "";
    private JSONObject jsonObject;

    @Given("The endpoint is given for movies with headers")
    public void the_endpoint_is_given_for_movies_with_headers() {
        uri = "";
    }

    @When("Hit the API for movies with headers")
    public void hit_the_api_for_movies_with_headers() throws FileNotFoundException {
        requestSpecification = baseBuilder.placeSpecBuilder();
        response = given()
                .header("Authorization", "Bearer 4qAaXynbVomwqHwO6MXW")
                .spec(requestSpecification)
                .when()
                .log().all()
                .get(GlobalConstant.getAllMovies);

        System.out.println(response.toString());

    }

    @Then("Validate the status code for movies with headers")
    public void validate_the_status_code_for_movies_with_headers() {
        Utils.verifyStatusCode(response, GlobalConstant.HTTP_OK); // Also verifying the status code here
    }

    @Then("Validate for positive Test Case with headers")
    public void validate_for_positive_test_case_with_headers() throws JSONException {
        jsonObject = Utils.extractJsonObjectFromResponse(response);
        System.out.println(response.asString());
        JSONArray docs = jsonObject.getJSONArray("docs");
        int length = docs.length();
        Assert.assertTrue(length>0);
    }

}
