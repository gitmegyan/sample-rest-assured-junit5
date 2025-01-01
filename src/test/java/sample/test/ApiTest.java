package sample.test;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    String BASE_URL = "https://reqres.in/api";

    @Test
    public void createUser() {
        JSONObject data = new JSONObject();
        data.put("name", "NewUSer1");
        data.put("job", "Testing");

        given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .when()
                .post(BASE_URL + "/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("NewUser1"))
                .body("job", equalTo("Testing"))
                .log()
                .all();
    }
}
