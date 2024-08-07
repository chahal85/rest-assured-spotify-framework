package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstTest {
    @Test
    void testRest() {
        given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-667f17c701b3e40001322f71-90434eea870b09fb4894e5ff69136fffbc").
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }
}
