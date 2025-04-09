package com.tripit.tripit_backend.meetup.infra.entity;

import com.tripit.tripit_backend.user.infra.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeetupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private MeetupPostEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity host;

    @Enumerated(EnumType.STRING)
    private MeetupStatus status;

}
