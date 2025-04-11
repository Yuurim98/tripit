package com.tripit.tripit_backend.travel.infra.api;

import com.tripit.tripit_backend.common.config.TravelApiProperties;
import com.tripit.tripit_backend.travel.application.port.TravelPlaceFetcher;
import com.tripit.tripit_backend.travel.infra.api.dto.TourApiResponseWrapper;
import com.tripit.tripit_backend.travel.infra.api.dto.TourApiResponseWrapper.TourApiTravelPlaceResponse;
import java.net.URI;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class TravelPlaceFetcherImpl implements TravelPlaceFetcher {

    private final WebClient webClient;
    private final TravelApiProperties travelApiProperties;

    public TravelPlaceFetcherImpl(WebClient.Builder webClientBuilder,
        TravelApiProperties travelApiProperties) {
        this.webClient = webClientBuilder.build();
        this.travelApiProperties = travelApiProperties;
    }

    @Override
    public List<TourApiTravelPlaceResponse> getPlacesByAreaCode(int page, int contentTypeId, int areaCode) {
        URI uri = buildTourApiUri(page, contentTypeId, areaCode);
        log.info("uri {}", uri);

        TourApiResponseWrapper response = fetchTourApiResponse(uri);

        return response
            .getResponse()
            .getBody()
            .getItems()
            .getItem();
    }

    private TourApiResponseWrapper fetchTourApiResponse(URI uri) {
        return webClient.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(TourApiResponseWrapper.class)
            .block();
    }

    private URI buildTourApiUri(int page, int contentTypeId, int areaCode) {
        return UriComponentsBuilder.fromUriString(
                travelApiProperties.getBaseUrl() + "/areaBasedList1")
            .queryParam("serviceKey", travelApiProperties.getServiceKey())
            .queryParam("MobileOS", travelApiProperties.getMobileOs())
            .queryParam("MobileApp", travelApiProperties.getMobileApp())
            .queryParam("_type", travelApiProperties.getType())
            .queryParam("areaCode", areaCode)
            .queryParam("contentTypeId", contentTypeId)
            .queryParam("pageNo", page)
            .build(true)
            .toUri();
    }
}
