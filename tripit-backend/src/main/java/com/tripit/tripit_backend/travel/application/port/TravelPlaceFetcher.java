package com.tripit.tripit_backend.travel.application.port;

import com.tripit.tripit_backend.travel.infra.api.dto.TourApiResponseWrapper.TourApiTravelPlaceResponse;
import java.util.List;

public interface TravelPlaceFetcher {

    List<TourApiTravelPlaceResponse> getPlacesByAreaCode(int page, int contentTypeId, int areaCode);

}
