package api;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import core.APIBaseTest;
import core.APIConstants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ProductAPITest{
    APIBaseTest api = new APIBaseTest();
    Logger logger = LogManager.getLogger(ProductAPITest.class);

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = APIConstants.BASE_URL;
    }

    @Test(description = "API 1: Get All Products List")
    public void testGetAllProducts() {
        logger.info("API 1: Get All Products List");
        Response response = api.get(APIConstants.PRODUCT_LIST_LINK);
        Assert.assertEquals(response.statusCode(), 200);
        logger.info("Response Status Code: " + response.statusCode());
        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getInt("responseCode"), 200);
        logger.info("Response Code: " + json.getInt("responseCode"));

        int productSize = json.getList("products").size();
        Assert.assertTrue(productSize > 0);
        logger.info("Product Size: " + productSize);
    }

    @Test(description = "API 2: POST To All Products List")
    public void testPostToAllProducts() {
        logger.info("API 2: POST To All Products List");
        Map<String, Object> body = new HashMap<>();
        body.put("name", "Premium Product");
        body.put("price", "Rs. 50");
        body.put("category", "Tops");
        
        Response response = api.post(APIConstants.PRODUCT_LIST_LINK, body);
        Assert.assertEquals(response.statusCode(), 200);
        logger.info("Response Status Code: " + response.statusCode()); 
        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getInt("responseCode"), 405);
        logger.info("Response Code: " + json.getInt("responseCode"));

        String responseMessage = json.getString("message"); 
        Assert.assertEquals(responseMessage, "This request method is not supported.");
        logger.info("Response Message: " + responseMessage);
    }

    @Test(description = "API 3: Get All Brands List")
    public void testGetAllBrands() {
        logger.info("API 3: Get All Brands List");
        Response response = api.get(APIConstants.BRAND_LIST_LINK);
        Assert.assertEquals(response.statusCode(), 200);
        logger.info("Response Status Code: " + response.statusCode());
        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getInt("responseCode"), 200);
        logger.info("Response Code: " + json.getInt("responseCode"));

        int brandSize = json.getList("brands").size();
        Assert.assertTrue(brandSize > 0);
        logger.info("Brand Size: " + brandSize);
    }

    @Test(description = "API 4: PUT To All Brands List")
    public void testPutToAllBrands() {
        logger.info("API 4: PUT To All Brands List");
        Map<String, Object> body = new HashMap<>();
        body.put("brand", "Polo");
        
        Response response = api.put(APIConstants.BRAND_LIST_LINK, body);
        Assert.assertEquals(response.statusCode(), 200); 
        logger.info("Response Status Code: " + response.statusCode());
        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getInt("responseCode"), 405);
        logger.info("Response Code: " + json.getInt("responseCode"));

        String responseMessage = json.getString("message"); 
        Assert.assertEquals(responseMessage, "This request method is not supported.");
        logger.info("Response Message: " + responseMessage);
    }
}