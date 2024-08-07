package applicationApi;

import api.RestResource;
import com.spotify.pojos.Playlist;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.ConfigLoader;

import static api.Route.PLAYLISTS;
import static api.Route.USERS;
import static api.TokenManager.getToken;

public class PlaylistApi {
    @Step
    public static Response post(Playlist playlistPayload) {
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, getToken(), playlistPayload);
    }

    public static Response get(String playlistId) {
        return RestResource.get(PLAYLISTS + "/" + playlistId, getToken());
    }

    public static Response put(String playlistId, Playlist playlistPayload) {
        return RestResource.put(PLAYLISTS + "/" + playlistId, getToken(), playlistPayload);
    }
}
