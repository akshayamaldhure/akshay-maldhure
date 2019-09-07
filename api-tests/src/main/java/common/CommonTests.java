package common;

import config.Environment;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CommonTests {

    public static Response getHealthCheckResponse() {
        return given()
                .spec(Spec.requestSpec)
                .get(Environment.healthcheck);
    }
}