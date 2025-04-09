package com.tripit.tripit_backend.travel.infra.entity;

import com.tripit.tripit_backend.user.infra.entity.UserEntity;
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
public class TripsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @OneToMany(mappedBy = "trips", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItinerariesEntity> itinerariesEntities = new ArrayList<>();

    private int areaCode;

    private String name;

    private LocalDate start;

    private LocalDate end;

}
