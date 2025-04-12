package com.tripit.tripit_backend.travel.domain;

import com.tripit.tripit_backend.travel.infra.entity.TripEntity;
import java.util.List;

public interface TripRepository {

    List<TripEntity> findAllByUserId(Long userId);


}
