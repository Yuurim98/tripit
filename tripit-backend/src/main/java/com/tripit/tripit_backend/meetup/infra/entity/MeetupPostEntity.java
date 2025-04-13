package com.tripit.tripit_backend.meetup.infra.entity;

import com.tripit.tripit_backend.common.entity.BaseEntity;
import com.tripit.tripit_backend.travel.infra.entity.TripEntity;
import com.tripit.tripit_backend.user.infra.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeetupPostEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private TripEntity trips;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    private String title;

    @Lob
    private String content;

    private int personnel;

    private Long viewCount = 0L;

}
