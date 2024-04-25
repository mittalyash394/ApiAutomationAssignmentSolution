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
import utilities.PropertyReader;
import utilities.Utils;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class GetBooksData {

    public RequestSpecification requestSpecification;

    BaseBuilder baseBuilder = new BaseBuilder();

    private Response response;

    String uri = "";
    private JSONObject jsonObject;

    @Given("The endpoint is given")
    public void the_endpoint_is_given() {
        uri = "";
    }

    @When("Hit the API")
    public void hit_the_api() throws FileNotFoundException {

        //for hitting the API, made a request, here
        requestSpecification = baseBuilder.placeSpecBuilder();
        response = given()
                .spec(requestSpecification)
                .when()
                .log().all()
                .get(GlobalConstant.getBooksData);

        System.out.println(response.toString());
    }

    @Then("Validate the status code for books API")
    public void validate_the_status_code_for_books_api() {
        Utils.verifyStatusCode(response, GlobalConstant.HTTP_OK); // Also verifying the status code here
    }

    @Then("Count the number of items")
    public void count_the_number_of_items() throws JSONException {
        jsonObject = Utils.extractJsonObjectFromResponse(response);
        System.out.println(response.asString());
        JSONArray docs = jsonObject.getJSONArray("docs");
        int length = docs.length();
        System.out.println("YASH" + length);
        Assert.assertEquals(3, length);

        // OR we can also do this by, validating the value from jsonKey, total, then validate.

//        int total = jsonObject.getInt("total");
//        Assert.assertEquals(3, total);
    }

}
