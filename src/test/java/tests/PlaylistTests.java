package tests;

import applicationApi.PlaylistApi;
import com.spotify.pojos.Playlist;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.DataLoader;
import utils.FakerUtils;

import static api.SpecBuilder.getRequestSpec;
import static api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTests {
    @Test(description = "should be able to create a playlist")
    void successful_creation_of_playlist() {
        Playlist playlistPayload = Playlist.builder()
                .name(FakerUtils.generateName())
                .description(FakerUtils.generateDescription())
                .isPublic(false)
                .build();

        Response response = PlaylistApi.post(playlistPayload);
        assertThat(response.statusCode(), equalTo(201));

//        Playlist playlistResponse = response.as(Playlist.class);
//        assertThat(playlistResponse.getName(), equalTo(playlistPayload.getName()));
//        assertThat(playlistResponse.getDescription(), equalTo(playlistPayload.getDescription()));
//        assertThat(playlistResponse.isPublic(), equalTo(playlistPayload.isPublic()));
    }

    @Test
    void shouldBeAbleToFetchPlaylistDetails() {
        String playlistId = DataLoader.getInstance().getGetPlaylistId();
        Response response = PlaylistApi.get(playlistId);

    }

    @Test
    void should_be_able_to_update_playlist() {
        Playlist playlistPayload = Playlist.builder()
                .name(FakerUtils.generateName())
                .description(FakerUtils.generateDescription())
                .isPublic(false)
                .build();

        String playlistId = DataLoader.getInstance().getUpdatePlaylistId();

        Response response = PlaylistApi.put(playlistId, playlistPayload);
    }
}
