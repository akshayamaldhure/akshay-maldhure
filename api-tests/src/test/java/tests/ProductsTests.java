package tests;

import common.MyLogger;
import components.ProductsComponent;
import io.restassured.common.mapper.TypeRef;
import models.common.AllEntitiesResponse;
import models.common.ErrorResponse;
import models.entities.Product;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTests {

    private Logger log = MyLogger.log;

    @DataProvider
    public Object[][] getLimitAndSkip() {
        return new Object[][]{
                {50, 0},
                {10, 0},
                {100, 0}
        };
    }

    @DataProvider
    public Object[][] getProductIdAndName() {
        return new Object[][]{
                {43900, "Duracell - AAA Batteries (4-Pack)"},
                {48530, "Duracell - AA 1.5V CopperTop Batteries (4-Pack)"},
                {127687, "Duracell - AA Batteries (8-Pack)"}
        };
    }

    @Test
    @Parameters({"defaultProductsLimit"})
    public void verifyDefaultProductLimit(String defaultProductsLimit) {
        AllEntitiesResponse<Product> products = ProductsComponent.getProducts().getBody().as(new TypeRef<AllEntitiesResponse<Product>>() {
        });
        assertEquals(products.getDataCount(), products.getLimit());
        assertEquals(products.getDataCount(), Long.parseLong(defaultProductsLimit));
    }

    @Test(dataProvider = "getLimitAndSkip")
    public void verifyProductLimit(Object limit, Object skip) {
        AllEntitiesResponse<Product> products = ProductsComponent.getProducts(limit, skip, true).getBody().as(new TypeRef<AllEntitiesResponse<Product>>() {
        });
        assertEquals(products.getLimit(), products.getDataCount());
    }

    @Test(dataProvider = "getProductIdAndName")
    public void verifyProductDetails(Object productId, Object expectedProductName) {
        Product product = ProductsComponent.getProductDetails(productId, true).getBody().as(Product.class);
        assertEquals(product.getName(), expectedProductName);
    }

    @Test
    @Parameters({"invalidProductId"})
    public void verifyAllProductsReturns404ForInvalidProductId(String invalidProductId) {
        ErrorResponse errorResponse = ProductsComponent.getProductDetails(invalidProductId, false).getBody().as(ErrorResponse.class);
        assertEquals(errorResponse.getMessage(), "No record found for id '" + invalidProductId + "'");
        assertEquals(errorResponse.getCode(), 404);
    }
}

