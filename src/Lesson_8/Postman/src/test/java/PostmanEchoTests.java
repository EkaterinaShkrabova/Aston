import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class PostmanEchoTests {

    @Test
    public void getRequestTest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void postRequestTest() {
        given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "__cf_bm=mtI0ZZXMEg4IcFyq_6L1gbjHPGvhKfzvlUm4VTMqo3k-1765802620-1.0.1.1-Xh9EouEKEqIB4Bp.pQjo5XZLjAtpeK7aZwUqmwz_oMv2.lyszz_j9WzfQAN_i2svzUwtZ_cc8UwuCxZw0r5eeTrqdgFtTAe_UuiWRaZoKCE")
                .body("{\"test\": \"value\"}")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                // Проверка тела ответа на наличие нужного JSON
                .body("json.test", equalTo("value"))
                // Проверка заголовков ответа
                .header("Content-Type", containsString("application/json"))
                .header("Server", notNullValue())
                .header("x-response-time", notNullValue())
                .header("X-Processing-Time", notNullValue())
                // Проверка наличия cookie в ответе (если сервер возвращает cookie)
                .cookie("sails.sid", notNullValue())
        ;
    }
}