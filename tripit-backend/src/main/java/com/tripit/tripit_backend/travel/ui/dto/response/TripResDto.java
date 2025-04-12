package com.tripit.tripit_backend.travel.ui.dto.response;

import com.tripit.tripit_backend.travel.infra.entity.TripEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TripResDto {

    private Long id;

    private int areaCode;

    private String name;

    private LocalDate start;

    private LocalDate end;

    private LocalDateTime createdAt;

    public static TripResDto from(TripEntity tripEntity) {
        return TripResDto.builder()
            .id(tripEntity.getId())
            .areaCode(tripEntity.getAreaCode())
            .name(tripEntity.getName())
            .start(tripEntity.getStart())
            .end(tripEntity.getEnd())
            .createdAt(tripEntity.getCreatedAt())
            .build();
    }


}
