package com.tripit.tripit_backend.travel.infra;

import com.tripit.tripit_backend.travel.infra.entity.TripEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripJpaRepository extends JpaRepository<TripEntity, Long> {

    List<TripEntity> findAllByUserId(Long userId);

}
