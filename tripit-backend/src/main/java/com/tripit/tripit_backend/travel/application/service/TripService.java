package com.tripit.tripit_backend.travel.application.service;

import com.tripit.tripit_backend.travel.domain.TripRepository;
import com.tripit.tripit_backend.travel.infra.entity.TripEntity;
import com.tripit.tripit_backend.travel.ui.dto.response.TripResDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository repository;

    public List<TripResDto> getTripList(Long userId) {

        List<TripEntity> entities = repository.findAllByUserId(userId);
        return entities.stream()
            .map(TripResDto::from)
            .toList();
    }

}
