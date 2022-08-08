package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ReqresTests {

    @Test
    void listUsers () {

        String body = "{ \"data\": { \"id\": 2, \"email\": \"janet.weaver@reqres.in\", \"first_name\": \"Janet\", " +
                "\"last_name\": \"Weaver\", \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\" }, \"support\": " +
                "{ \"url\": \"https://reqres.in/#support-heading\", \"text\": \"To keep ReqRes free, contributions " +
                "towards server costs are appreciated!\" } }";

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body();
    }
}
