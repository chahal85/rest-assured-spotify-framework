package api;

import com.spotify.pojos.Playlist;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static api.Route.API;
import static api.Route.TOKEN;
import static api.SpecBuilder.*;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class RestResource {
    public static Response post(String path, String token, Object payload) {
        return given().
                    spec(getRequestSpec())
                .filter(new AllureRestAssured())
                    .auth().oauth2(token)
                    .body(payload).
                when().
                    post(path).
                then().
                    extract().
                    response();
    }

    public static Response get(String path, String token) {
        // playlist id - 0Zsna52WPx9zjKK87qrs6D
        return given().
                    spec(getRequestSpec())
                    .auth().oauth2(token).
                when().
                    get(path).
                then().
                    extract().
                    response();
    }

    public static Response put(String path, String token, Object payload) {
        return given()
                    .spec(getRequestSpec())
                    .auth().oauth2(token)
                    .body(payload).
                when().
                    put(path).
                then()
                    .extract()
                    .response();
    }

    public static Response postAccount(HashMap<String, String> formParams) {
        return given().
                spec(getAccountRequestSpec()).
                formParams(formParams).
                when().
                post(API + TOKEN).
                then().
                spec(getResponseSpec()).
                extract().
                response();
    }
}
