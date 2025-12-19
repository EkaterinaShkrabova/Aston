import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApiTests {

    // Объявляем базовый URL (можно вынести в конфигурацию)
    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetWithCookies() {
        given()
                .header("Cookie", "__cf_bm=xovq6ieUb0VF8i6AAmAKG3zoHIRDVObrP4PBe0deCp8-1766143124-1.0.1.1-bExUZM.488w1zCxDkTYv5irys6ePVR5q_nQRXfzXG7o52PpOKkhCLXAguj1H8T2gA.cXBrUwVhRLm16HsbUHbFySuJvyRPb2Xe6S")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get(BASE_URL+"/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.cookie", containsString("__cf_bm"));
    }


    @Test
    public void testPostPlainText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "...")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/post")
                .then()
                .statusCode(200)
                .extract().response();

        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains(requestBody));
    }

    @Test
    public void testPostUrlEncoded() {
        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", "...")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post(BASE_URL + "/post")
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals("bar1", response.jsonPath().getString("form.foo1"));
        assertEquals("bar2", response.jsonPath().getString("form.foo2"));
    }

    @Test
    public void testPut() {
        String payload = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "...")
                .body(payload)
                .when()
                .put(BASE_URL + "/put")
                .then()
                .statusCode(200)
                .extract().response();

        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains(payload));
    }

    @Test
    public void testPatch() {
        String payload = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "...")
                .body(payload)
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .statusCode(200)
                .extract().response();

        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains(payload));
    }

    @Test
    public void testDelete() {
        Response response = given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "...")
                .when()
                .delete(BASE_URL + "/delete")
                .then()
                .statusCode(200)
                .extract().response();

        // Можно проверить тело, например, что содержит определённый текст
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("This is expected to be sent back as part of response body."));
    }
}