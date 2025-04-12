package com.tripit.tripit_backend.travel.application.service;

import com.tripit.tripit_backend.travel.application.port.TravelPlaceFetcher;
import com.tripit.tripit_backend.travel.infra.api.dto.TourApiResponseWrapper.TourApiTravelPlaceResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TravelPlaceService {

    private final TravelPlaceFetcher travelPlaceFetcher;

    public List<TourApiTravelPlaceResponse> getTravelPlace(int page, int contentTypeId, int areaCode) {
        return travelPlaceFetcher.getPlacesByAreaCode(page, contentTypeId, areaCode);
    }

}
