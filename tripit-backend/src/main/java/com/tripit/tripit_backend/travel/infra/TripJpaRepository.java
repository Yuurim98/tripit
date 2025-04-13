package com.tripit.tripit_backend.travel.infra;

import com.tripit.tripit_backend.travel.infra.entity.TripEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TripJpaRepository extends JpaRepository<TripEntity, Long> {

    List<TripEntity> findAllByUserIdAndDeletedAtIsNull(Long userId);

    @EntityGraph(attributePaths = "itineraries")
    @Query("SELECT t FROM TripEntity t WHERE t.id = :tripId AND t.deletedAt IS NULL")
    Optional<TripEntity> findByIdWithItinerariesAndActivitiesAndDeletedAtIsNull(@Param("tripId") Long tripId);

}
