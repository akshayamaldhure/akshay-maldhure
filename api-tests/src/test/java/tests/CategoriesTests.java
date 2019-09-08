package tests;

import components.HttpClient;
import config.Environment;
import io.restassured.common.mapper.TypeRef;
import models.common.AllEntitiesResponse;
import models.common.ErrorResponse;
import models.entities.Category;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CategoriesTests {

    private HttpClient categoriesHttpClient;

    @BeforeClass
    public void setup() {
        categoriesHttpClient = new HttpClient(Environment.categories);
    }

    @DataProvider
    public Object[][] getLimitAndSkip() {
        return new Object[][]{
                {50, 0},
                {10, 0},
                {100, 0}
        };
    }

    @DataProvider
    public Object[][] getCategoryIdAndName() {
        return new Object[][]{
                {"abcat0010000", "Gift Ideas"},
                {"abcat0020001", "Learning Toys"},
                {"abcat0020002", "DVD Games"}
        };
    }

    @Test
    @Parameters({"defaultEntityLimit"})
    public void verifyDefaultCategoryLimit(String defaultEntityLimit) {
        AllEntitiesResponse<Category> categories = categoriesHttpClient.getEntities().getBody().as(new TypeRef<AllEntitiesResponse<Category>>() {
        });
        assertEquals(categories.getDataCount(), categories.getLimit());
        assertEquals(categories.getDataCount(), Long.parseLong(defaultEntityLimit));
    }

    @Test(dataProvider = "getLimitAndSkip")
    public void verifyCategoryLimit(Object limit, Object skip) {
        AllEntitiesResponse<Category> categories = categoriesHttpClient.getEntities(limit, skip, true).getBody().as(new TypeRef<AllEntitiesResponse<Category>>() {
        });
        assertEquals(categories.getLimit(), categories.getDataCount());
    }

    @Test(dataProvider = "getCategoryIdAndName")
    public void verifyCategoryDetails(Object categoryId, Object expectedCategoryName) {
        Category category = categoriesHttpClient.getEntityDetails(categoryId, true).getBody().as(Category.class);
        assertEquals(category.getName(), expectedCategoryName);
    }

    @Test
    @Parameters({"invalidEntityId"})
    public void verifyReturns404ForInvalidCategoryId(String invalidEntityId) {
        ErrorResponse errorResponse = categoriesHttpClient.getEntityDetails(invalidEntityId, false).getBody().as(ErrorResponse.class);
        assertEquals(errorResponse.getMessage(), "No record found for id '" + invalidEntityId + "'");
        assertEquals(errorResponse.getCode(), 404);
    }
}

