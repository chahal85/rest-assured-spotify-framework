package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigLoader;

import java.time.Instant;
import java.util.HashMap;
import java.util.Objects;

import static api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.form;
import static io.restassured.RestAssured.given;

public class TokenManager {
    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String getToken() {
        try{
            if(Objects.isNull(access_token) || Instant.now().isAfter(expiry_time)) {
                System.out.println("||||| Renewing Token |||||");
                Response response = renewToken();
                access_token = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 300);
            }
            else {
                System.out.println("||||| Token is good to use |||||");
            }
        }
        catch(Exception e) {

        }
        return access_token;
    }

    private static Response renewToken() {
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", "refresh_token");
        formParams.put("refresh_token", ConfigLoader.getInstance().getRefreshToken());
        formParams.put("client_id", ConfigLoader.getInstance().getClientId());
        formParams.put("client_secret", ConfigLoader.getInstance().getClientSecret());

        Response response = RestResource.postAccount(formParams);

        if(response.statusCode() != 200) {
            throw new RuntimeException("Abort !!! Renew token failed.");
        }

        return response;
    }
}
