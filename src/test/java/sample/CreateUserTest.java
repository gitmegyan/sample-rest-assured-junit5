package sample;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.constant.client.RestAssuredClient;

import java.util.HashMap;
import java.util.Map;

import static sample.constant.ApiConstant.CREATE_USER_ENDPOINT;


public class CreateUserTest {
    private  RestAssuredClient restAssuredClient;
    private Map<String, String> headers = new HashMap<>();

    @BeforeEach
    public void setUp() {
        restAssuredClient = new RestAssuredClient();
        headers.put("Content-Type", "application/json");
    }

    @Test
    public void createUserWithStatusCode_201() {
        JSONObject data = new JSONObject();
        data.put("name", "NewUSer1");
        data.put("job", "Testing");
        Response response = restAssuredClient.post(CREATE_USER_ENDPOINT, headers, data);
        response
                .then()
                .statusCode(201);
    }
}
