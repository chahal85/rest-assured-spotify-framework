package utils;

import java.util.Objects;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        if(Objects.isNull(configLoader)) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId() {
        String prop = properties.getProperty("client_id");
        if(Objects.isNull(prop)) {
            throw new RuntimeException("property client_id is not specified in the config.properties");
        }

        return prop;
    }


    public String getRefreshToken() {
        String prop = properties.getProperty("refresh_token");
        if(Objects.isNull(prop)) {
            throw new RuntimeException("property refresh_token is not specified in the config.properties");
        }

        return prop;
    }

    public String getClientSecret() {
        String prop = properties.getProperty("client_secret");
        if(Objects.isNull(prop)) {
            throw new RuntimeException("property refreshclient_secret_token is not specified in the config.properties");
        }

        return prop;
    }
    public String getUserId() {
        String prop = properties.getProperty("user_id");
        if(Objects.isNull(prop)) {
            throw new RuntimeException("property user_id is not specified in the config.properties");
        }

        return prop;
    }
}
