package com.tripit.tripit_backend.travel.application.service;

import com.tripit.tripit_backend.common.exception.CustomException;
import com.tripit.tripit_backend.common.exception.ErrorCode;
import com.tripit.tripit_backend.travel.domain.TripRepository;
import com.tripit.tripit_backend.travel.infra.entity.TripEntity;
import com.tripit.tripit_backend.travel.ui.dto.response.ItineraryResDto;
import com.tripit.tripit_backend.travel.ui.dto.response.TripResDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository repository;

    public List<TripResDto> getTripList(Long userId) {

        List<TripEntity> entities = repository.findAllByUserIdAndDeletedAtIsNull(userId);
        return entities.stream()
            .map(TripResDto::from)
            .toList();
    }

    public List<ItineraryResDto> getTripDetails(Long tripId) {
        TripEntity tripEntity = repository.findByIdWithItinerariesAndActivities(tripId)
            .orElseThrow(() -> new CustomException(ErrorCode.TRIP_NOT_FOUND));

        return tripEntity.getItineraries().stream()
            .map(ItineraryResDto::from)
            .collect(Collectors.toList());
    }

}
