package components;

import common.Spec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Create HTTP requests at a given endpoint
 */

public class HttpClient {

    String endpoint;

    public HttpClient(String endpoint) {
        this.endpoint = endpoint;
    }

    public Response getEntities() {
        return getEntities(10, 0, true);
    }

    public Response getEntities(Object limit, Object skip, boolean expectSuccess) {
        Response allEntitiesResponse = given()
                .spec(Spec.requestSpec)
                .param("$limit", limit)
                .param("$skip", skip)
                .get(this.endpoint);
        if (expectSuccess)
            allEntitiesResponse
                    .then()
                    .assertThat()
                    .spec(Spec.successResponseSpec);
        return allEntitiesResponse;
    }

    public Response getEntityDetails(Object productId, boolean expectSuccess) {
        Response entityDetailsResponse = given()
                .spec(Spec.requestSpec)
                .get(this.endpoint + "/" + productId.toString());
        if (expectSuccess)
            entityDetailsResponse
                    .then()
                    .assertThat()
                    .spec(Spec.successResponseSpec);
        return entityDetailsResponse;
    }

    public Response deleteEntity(Object productId, boolean expectSuccess) {
        Response deleteProductResponse = given()
                .spec(Spec.requestSpec)
                .get(this.endpoint + "/" + productId.toString());
        if (expectSuccess)
            deleteProductResponse
                    .then()
                    .assertThat()
                    .spec(Spec.successResponseSpec);
        return deleteProductResponse;
    }
}
