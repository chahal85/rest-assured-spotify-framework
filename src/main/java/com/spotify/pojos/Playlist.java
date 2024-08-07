package com.spotify.pojos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class Playlist {
    private boolean collaborative;
    private String description;
    private Map<String, String> external_urls;
    private Followers followers;
    private String href;
    private String id;
    private List<Object> images; // Assuming images is a list of objects (can be changed based on actual structure)
    private String primary_color;
    private String name;
    private String type;
    private String uri;
    private Owner owner;
    private boolean isPublic;
    private String snapshot_id;
    private Tracks tracks;

    @Override
    public String toString() {
        return "Playlist{" +
                "collaborative=" + collaborative +
                ", description='" + description + '\'' +
                ", external_urls=" + external_urls +
                ", followers=" + followers +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", primary_color='" + primary_color + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                ", owner=" + owner +
                ", isPublic=" + isPublic +
                ", snapshot_id='" + snapshot_id + '\'' +
                ", tracks=" + tracks +
                '}';
    }

    public static class Followers {
        @JsonIgnoreProperties
        private String href;
        private int total;

        // Getters and Setters

        @Override
        public String toString() {
            return "Followers{" +
                    "href='" + href + '\'' +
                    ", total=" + total +
                    '}';
        }
    }

    public static class Owner {
        private String href;
        private String id;
        private String type;
        private String uri;
        private String display_name;
        private Map<String, String> external_urls;

        // Getters and Setters

        @Override
        public String toString() {
            return "Owner{" +
                    "href='" + href + '\'' +
                    ", id='" + id + '\'' +
                    ", type='" + type + '\'' +
                    ", uri='" + uri + '\'' +
                    ", display_name='" + display_name + '\'' +
                    ", external_urls=" + external_urls +
                    '}';
        }
    }

    public static class Tracks {
        private int limit;
        private String next;
        private int offset;
        private String previous;
        private String href;
        private int total;
        private List<Object> items; // Assuming items is a list of objects (can be changed based on actual structure)

        // Getters and Setters

        @Override
        public String toString() {
            return "Tracks{" +
                    "limit=" + limit +
                    ", next='" + next + '\'' +
                    ", offset=" + offset +
                    ", previous='" + previous + '\'' +
                    ", href='" + href + '\'' +
                    ", total=" + total +
                    ", items=" + items +
                    '}';
        }
    }
}
