package com.tripit.tripit_backend.travel.ui;

import com.tripit.tripit_backend.common.exception.CustomException;
import com.tripit.tripit_backend.common.exception.ErrorCode;
import com.tripit.tripit_backend.common.response.ApiResponse;
import com.tripit.tripit_backend.travel.application.service.TravelPlaceService;
import com.tripit.tripit_backend.travel.domain.model.ContentType;
import com.tripit.tripit_backend.travel.infra.api.dto.TourApiResponseWrapper.TourApiTravelPlaceResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TravelPlaceController {

    private final TravelPlaceService travelPlaceService;

    @GetMapping("/places/areas")
    public ResponseEntity<ApiResponse<List<TourApiTravelPlaceResponse>>> getTravelPlace(
        @RequestParam("page") int page,
        @RequestParam(name = "content-type-id", defaultValue = "12") int contentTypeId,
        @RequestParam("area-code") int areaCode) {

        if (!ContentType.isValid(contentTypeId)) {
            throw new CustomException(ErrorCode.INVALID_REQUEST);
        }
        return ResponseEntity.ok(
            ApiResponse.success(travelPlaceService.getTravelPlace(page, contentTypeId, areaCode)));
    }

}
