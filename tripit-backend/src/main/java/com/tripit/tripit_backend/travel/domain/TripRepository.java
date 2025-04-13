package com.tripit.tripit_backend.travel.domain;

import com.tripit.tripit_backend.travel.infra.entity.TripEntity;
import java.util.List;
import java.util.Optional;

public interface TripRepository {

    List<TripEntity> findAllByUserIdAndDeletedAtIsNull(Long userId);

    Optional<TripEntity> findByIdWithItinerariesAndActivities(Long tripId);


}
