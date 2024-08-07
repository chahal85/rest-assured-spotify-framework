package utils;

import java.util.Objects;
import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataconfigLoader;

    private DataLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance() {
        if(Objects.isNull(dataconfigLoader)) {
            dataconfigLoader = new DataLoader();
        }
        return dataconfigLoader;
    }

    public String getGetPlaylistId() {
        String prop = properties.getProperty("get_playlist_id");
        if(Objects.isNull(prop)) {
            throw new RuntimeException("property get_playlist_id is not specified in the config.properties");
        }

        return prop;
    }


    public String getUpdatePlaylistId() {
        String prop = properties.getProperty("update_playlist_id");
        if(Objects.isNull(prop)) {
            throw new RuntimeException("property update_playlist_id is not specified in the config.properties");
        }

        return prop;
    }
}
