package utilities;

import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;

public class Utils {

    public static JSONObject extractJsonObjectFromResponse(Response response) throws JSONException {
        String responseBody = response.getBody().asString();
        return new JSONObject(responseBody);
    }

    public static void verifyStatusCode(Response response, int statusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(statusCode, actualStatusCode);
    }

    public static void assertJsonValueEquals(String param, String expectedValue, JSONObject jsonObject) throws JSONException {
        assertEquals(expectedValue, jsonObject.get(param).toString());
    }

}
