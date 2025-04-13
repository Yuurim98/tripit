package com.tripit.tripit_backend.meetup.infra.entity;

import com.tripit.tripit_backend.common.entity.BaseEntity;
import com.tripit.tripit_backend.user.infra.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeetupApplicationsEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private MeetupEntity meetup;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    private String content;

    @Enumerated(EnumType.STRING)
    private MeetupApplicationsStatus status;

}
