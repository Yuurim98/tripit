package com.tripit.tripit_backend.travel.infra.entity;

import com.tripit.tripit_backend.common.entity.BaseEntity;
import com.tripit.tripit_backend.user.infra.entity.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trips_entity")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TripEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItineraryEntity> itineraries = new ArrayList<>();

    private int areaCode;

    private String name;

    private LocalDate start;

    private LocalDate end;

}
