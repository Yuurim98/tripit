package com.tripit.tripit_backend.travel.infra;

import com.tripit.tripit_backend.travel.domain.TripRepository;
import com.tripit.tripit_backend.travel.infra.entity.TripEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TripRepositoryImpl implements TripRepository {

    private final TripJpaRepository repository;

    @Override
    public List<TripEntity> findAllByUserIdAndDeletedAtIsNull(Long userId) {
        return repository.findAllByUserIdAndDeletedAtIsNull(userId);
    }

    @Override
    public Optional<TripEntity> findByIdWithItinerariesAndActivities(Long tripId) {
        return repository.findByIdWithItinerariesAndActivitiesAndDeletedAtIsNull(tripId);
    }
}
