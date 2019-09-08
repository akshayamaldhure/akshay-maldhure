package tests;

import components.HttpClient;
import config.Environment;
import io.restassured.common.mapper.TypeRef;
import models.common.AllEntitiesResponse;
import models.common.ErrorResponse;
import models.entities.Service;
import models.entities.Store;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StoresTests {

    private HttpClient storesHttpClient;

    @BeforeClass
    public void setup() {
        storesHttpClient = new HttpClient(Environment.stores);
    }

    @DataProvider
    public Object[][] getLimitAndSkip() {
        return new Object[][]{
                {15, 0},
                {10, 0},
                {20, 0}
        };
    }

    @DataProvider
    public Object[][] getStoreIdAndName() {
        return new Object[][]{
                {4, "Minnetonka"},
                {6, "Inver Grove Heights"},
                {7, "Roseville"}
        };
    }

    @Test
    @Parameters({"defaultEntityLimit"})
    public void verifyDefaultStoreLimit(String defaultEntityLimit) {
        AllEntitiesResponse<Store> stores = storesHttpClient.getEntities().getBody().as(new TypeRef<AllEntitiesResponse<Store>>() {});
        assertEquals(stores.getDataCount(), stores.getLimit());
        assertEquals(stores.getDataCount(), Long.parseLong(defaultEntityLimit));
    }

    @Test(dataProvider = "getLimitAndSkip")
    public void verifyStoreLimit(Object limit, Object skip) {
        AllEntitiesResponse<Store> stores = storesHttpClient.getEntities(limit, skip, true).getBody().as(new TypeRef<AllEntitiesResponse<Store>>() {});
        assertEquals(stores.getLimit(), stores.getDataCount());
    }

    @Test(dataProvider = "getStoreIdAndName")
    public void verifyStoreDetails(Object serviceId, Object expectedServiceName) {
        Store store = storesHttpClient.getEntityDetails(serviceId, true).getBody().as(Store.class);
        assertEquals(store.getName(), expectedServiceName);
    }

    @Test
    @Parameters({"invalidEntityId"})
    public void verifyReturns404ForInvalidStoreId(String invalidEntityId) {
            ErrorResponse errorResponse = storesHttpClient.getEntityDetails(invalidEntityId, false).getBody().as(ErrorResponse.class);
            assertEquals(errorResponse.getMessage(), "No record found for id '" + invalidEntityId + "'");
            assertEquals(errorResponse.getCode(), 404);
        }
    }

