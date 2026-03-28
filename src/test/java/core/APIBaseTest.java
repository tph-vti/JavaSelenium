package core;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class APIBaseTest {
    public Response get(String endpoint) {
        return given().when().get(endpoint);
    }

    public Response post(String endpoint, Object body) {
        return given().contentType("application/json").body(body).when().post(endpoint);
    }

    public Response put(String endpoint, Object body) {
        return given().contentType("application/json").body(body).when().put(endpoint);
    }

    public Response delete(String endpoint) {
        return given().when().delete(endpoint);
    }
}