package com.tripit.tripit_backend.travel.infra.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;

@Getter
public class TourApiResponseWrapper {
    private Response response;

    @Getter
    public static class Response {
        private Body body;
    }

    @Getter
    public static class Body {
        private Items items;
    }

    @Getter
    public static class Items {
        private List<TourApiTravelPlaceResponse> item;
    }

    @Getter
    public static class TourApiTravelPlaceResponse {
        @JsonProperty("addr1")
        private String addr;

        @JsonProperty("areacode")
        private String areaCode;

        @JsonProperty("contentid")
        private String contentId;

        @JsonProperty("contenttypeid")
        private String contentTypeId;

        @JsonProperty("firstimage")
        private String primaryImageUrl;

        @JsonProperty("firstimage2")
        private String secondaryImageUrl;

        @JsonProperty("mapx")
        private String x;

        @JsonProperty("mapy")
        private String y;

        @JsonProperty("title")
        private String name;
    }
}
