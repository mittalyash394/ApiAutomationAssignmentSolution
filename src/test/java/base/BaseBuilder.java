package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.PropertyReader;

import java.io.FileNotFoundException;
import java.sql.*;

public class BaseBuilder {

    RequestSpecBuilder builder;
    RequestSpecification reqspec;
    Response response;

    private static PropertyReader reader = new PropertyReader();

    public RequestSpecification placeSpecBuilder() throws FileNotFoundException {
        builder = new RequestSpecBuilder();

        String env = "https://the-one-api.dev";
        if (env.equals("dev.env.host")) {
            //System.out.println("dev");
            builder.setBaseUri(reader.getValueFromConfig("dev.env.host"));
        } else {
            builder.setBaseUri(reader.getValueFromConfig("host"));
        }

        builder.setContentType("application/json");
        reqspec = builder.build();
        return reqspec;
    }


}
