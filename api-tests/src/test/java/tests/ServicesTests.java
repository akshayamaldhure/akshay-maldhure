package tests;

import components.HttpClient;
import config.Environment;
import io.restassured.common.mapper.TypeRef;
import models.common.AllEntitiesResponse;
import models.common.ErrorResponse;
import models.entities.Service;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ServicesTests {

    private HttpClient servicesHttpClient;

    @BeforeClass
    public void setup() {
        servicesHttpClient = new HttpClient(Environment.services);
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
    public Object[][] getServiceIdAndName() {
        return new Object[][]{
                {1, "Geek Squad Services"},
                {2, "Best Buy Mobile"},
                {3, "Best Buy For Business"}
        };
    }

    @Test
    @Parameters({"defaultEntityLimit"})
    public void verifyDefaultServiceLimit(String defaultEntityLimit) {
        AllEntitiesResponse<Service> services = servicesHttpClient.getEntities().getBody().as(new TypeRef<AllEntitiesResponse<Service>>() {
        });
        assertEquals(services.getDataCount(), services.getLimit());
        assertEquals(services.getDataCount(), Long.parseLong(defaultEntityLimit));
    }

    @Test(dataProvider = "getLimitAndSkip")
    public void verifyServiceLimit(Object limit, Object skip) {
        AllEntitiesResponse<Service> services = servicesHttpClient.getEntities(limit, skip, true).getBody().as(new TypeRef<AllEntitiesResponse<Service>>() {
        });
        assertEquals(services.getLimit(), services.getDataCount());
    }

    @Test(dataProvider = "getServiceIdAndName")
    public void verifyServiceDetails(Object serviceId, Object expectedServiceName) {
        Service service = servicesHttpClient.getEntityDetails(serviceId, true).getBody().as(Service.class);
        assertEquals(service.getName(), expectedServiceName);
    }

    @Test
    @Parameters({"invalidEntityId"})
    public void verifyReturns404ForInvalidServiceId(String invalidEntityId) {
            ErrorResponse errorResponse = servicesHttpClient.getEntityDetails(invalidEntityId, false).getBody().as(ErrorResponse.class);
            assertEquals(errorResponse.getMessage(), "No record found for id '" + invalidEntityId + "'");
            assertEquals(errorResponse.getCode(), 404);
        }
    }

