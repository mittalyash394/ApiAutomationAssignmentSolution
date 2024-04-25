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

public class ListOfMoviesAndDialogue {

    public RequestSpecification requestSpecification;

    BaseBuilder baseBuilder = new BaseBuilder();

    private Response response;

    String uri = "";
    private JSONObject jsonObject;


    @Given("The endpoint is given for movies list with headers")
    public void the_endpoint_is_given_for_movies_list_with_headers() {
        uri = "";
    }
    @When("Hit the API for single movie {string} with headers")
    public void hit_the_api_for_single_movie_with_headers(String id) throws FileNotFoundException {
        requestSpecification = baseBuilder.placeSpecBuilder();
        response = given()
                .header("Authorization", "Bearer 4qAaXynbVomwqHwO6MXW")
                .spec(requestSpecification)
                .when()
                .log().all()
                .get(GlobalConstant.getAllMovies + "/"  + id + "/quote");

        System.out.println(response.toString());


    }

    @Then("Verify the status code for single movie {string} with headers")
    public void verify_the_status_code_for_single_movie_with_headers(String string) {
        Utils.verifyStatusCode(response, GlobalConstant.HTTP_OK); // Also verifying the status code here
    }

    @Then("Validate the flow for single movie {string} with headers")
    public void validate_the_flow_for_single_movie_with_headers(String id) throws JSONException {
        jsonObject = Utils.extractJsonObjectFromResponse(response);
        System.out.println(response.asString());
        JSONArray docs = jsonObject.getJSONArray("docs");
        JSONObject singleMovie = (JSONObject) docs.get(0);
        String dialogue = singleMovie.getString("dialog");
        Utils.assertJsonValueEquals("dialog", dialogue, singleMovie);
    }

}
