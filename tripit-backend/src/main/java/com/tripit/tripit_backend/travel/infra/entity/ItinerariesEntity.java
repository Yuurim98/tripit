package com.tripit.tripit_backend.travel.infra.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItinerariesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private TripsEntity trips;

    @OneToMany(mappedBy = "itineraries", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActivitiesEntity> activitiesEntities = new ArrayList<>();

    private int dayNumber;

    private LocalDate date;
}
