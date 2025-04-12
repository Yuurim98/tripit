package com.tripit.tripit_backend.travel.ui;

import com.tripit.tripit_backend.common.response.ApiResponse;
import com.tripit.tripit_backend.travel.application.service.TripService;
import com.tripit.tripit_backend.travel.ui.dto.response.TripResDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService service;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<TripResDto>>> getTripList() {
        return ResponseEntity.ok(ApiResponse.success(service.getTripList(1L)));
    }

}
