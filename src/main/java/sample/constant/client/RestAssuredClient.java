package sample.constant.client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import sample.constant.ApiConstant;

import java.util.Map;

public class RestAssuredClient {

    private RequestSpecification requestSpecification;

    public RestAssuredClient() {
        requestSpecification = RestAssured.given().log().all();
    }


    public Response post (String endpoint, Map<String, String> headers, Object body) {
        return requestSpecification
                .headers(headers)
                .body(body.toString())
                .when()
                .post(ApiConstant.BASE_URL + endpoint);
    }
}
