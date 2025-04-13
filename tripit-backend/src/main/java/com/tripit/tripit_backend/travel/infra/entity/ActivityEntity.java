package com.tripit.tripit_backend.travel.infra.entity;

import com.tripit.tripit_backend.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activities_entity")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ActivityEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItineraryEntity itinerary;

    private String contentId;

    private LocalDateTime start;

    private LocalDateTime end;

}
