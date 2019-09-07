package components;

import common.Spec;
import config.Environment;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductsComponent { // each method in a component would return a REST-assured Response object

    public static Response getProducts() {
        return getProducts(10, 0, true);
    }

    public static Response getProducts(Object limit, Object skip, boolean expectSuccess) {
        Response allProductsResponse = given()
                .spec(Spec.requestSpec)
                .param("$limit", limit)
                .param("$skip", skip)
                .get(Environment.products);
        if(expectSuccess)
            allProductsResponse
                    .then()
                    .assertThat()
                    .spec(Spec.successResponseSpec);
        return allProductsResponse;
    }

    public static Response getProductDetails(Object productId, boolean expectSuccess) {
        Response productDetailsResponse = given()
                .spec(Spec.requestSpec)
                .get(Environment.products + "/" + productId.toString());
        if(expectSuccess)
            productDetailsResponse
                    .then()
                    .assertThat()
                    .spec(Spec.successResponseSpec);
        return productDetailsResponse;
    }
}
