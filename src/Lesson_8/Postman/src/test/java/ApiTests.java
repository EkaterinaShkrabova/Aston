import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ApiTests {

    @Test
    public void testGetRequest() {
        JsonPath response = given()
                .header("Cookie", "__cf_bm=cchNCXfimgvi1wf8yVkVRhP6tRDZg6OcjU3iewyl0Ss-1766144032-1.0.1.1-IojqU1jnAu6kLfhhSkAWWWe9YEm4g0mwnzzSloKYGsAJJW79_8g7w356XiKsdRzSY_VRbN82UqgtpE0pKSY5nBNQy2mol7N")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();

        Assertions.assertEquals("bar1", response.getString("args.foo1"));
        Assertions.assertEquals("bar2", response.getString("args.foo2"));
        Assertions.assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", response.getString("url"));
        Assertions.assertEquals("postman-echo.com", response.getString("headers.host"));
        Assertions.assertTrue(response.getString("headers.cookie").contains("__cf_bm"));
    }

    @Test
    public void testPostRequest() {
        String requestBody = "{ \"test\": \"value\" }";

        JsonPath response = given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "__cf_bm=8Skl79MrWNZZz9oZjWD9XnwZNU9vs5zYCXtOMC_koGY-1766148422-1.0.1.1-yBQLNJVrA1M8mS4OcI5iZlIpuzimqzlLc5w09pTG3N3W9JizZ2tl5G1BH2FfUGgxtZ.HjyLX3oi49JQu0VelH9peivjtaoNIrPHDU_Adct0")
                .body(requestBody)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();

        Assertions.assertEquals(requestBody, response.getString("data"));
        Assertions.assertTrue(response.getString("headers['content-type']").contains("text/plain"));
        Assertions.assertTrue(response.getString("headers.cookie").contains("__cf_bm"));
        Assertions.assertEquals("https://postman-echo.com/post", response.getString("url"));
    }

    @Test
    public void testPutRequest() {
        String bodyContent = "This is expected to be sent back as part of response body.";
        JsonPath response = given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "__cf_bm=xovq6ieUb0VF8i6AAmAKG3zoHIRDVObrP4PBe0deCp8-1766143124-1.0.1.1-bExUZM.488w1zCxDkTYv5irys6ePVR5q_nQRXfzXG7o52PpOKkhCLXAguj1H8T2gA.cXBrUwVhRLm16HsbUHbFySuJvyRPb2Xe6SAvsFhl0")
                .body(bodyContent)
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();

        Assertions.assertEquals(bodyContent, response.getString("data"));
        Assertions.assertEquals("https://postman-echo.com/put", response.getString("url"));
        Assertions.assertEquals("text/plain", response.getString("headers['content-type']"));
    }

    @Test
    public void testPatchRequest() {
        String bodyContent = "This is expected to be sent back as part of response body.";
        JsonPath response = given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "__cf_bm=xovq6ieUb0VF8i6AAmAKG3zoHIRDVObrP4PBe0deCp8-1766143124-1.0.1.1-bExUZM.488w1zCxDkTYv5irys6ePVR5q_nQRXfzXG7o52PpOKkhCLXAguj1H8T2gA.cXBrUwVhRLm16HsbUHbFySuJvyRPb2Xe6SAvsFhl0")
                .body(bodyContent)
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();

        Assertions.assertEquals(bodyContent, response.getString("data"));
        Assertions.assertEquals("https://postman-echo.com/patch", response.getString("url"));
        Assertions.assertEquals("text/plain", response.getString("headers['content-type']"));
    }

    @Test
    public void testDeleteRequest() {
        String bodyContent = "This is expected to be sent back as part of response body.";
        JsonPath response = given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "__cf_bm=cchNCXfimgvi1wf8yVkVRhP6tRDZg6OcjU3iewyl0Ss-1766144032-1.0.1.1-IojqU1jnAu6kLfhhSkAWWWe9YEm4g0mwnzzSloKYGsAJJW79_8g7w356XiKsdRzSY_VRbN82UqgtpE0pKSY5nBNQy2mol7N")
                .body(bodyContent)
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();

        Assertions.assertEquals(bodyContent, response.getString("data"));
        Assertions.assertEquals("https://postman-echo.com/delete", response.getString("url"));
        Assertions.assertEquals("text/plain", response.getString("headers['content-type']"));
    }
}