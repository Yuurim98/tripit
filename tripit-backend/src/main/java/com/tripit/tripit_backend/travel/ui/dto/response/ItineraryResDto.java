package com.tripit.tripit_backend.travel.ui.dto.response;

import com.tripit.tripit_backend.travel.infra.entity.ItineraryEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItineraryResDto {

    private Long itineraryId;
    private int dayNumber;
    private LocalDate date;
    private List<ActivityResDto> activities;

    public static ItineraryResDto from(ItineraryEntity itineraryEntity) {
        return ItineraryResDto.builder()
            .itineraryId(itineraryEntity.getId())
            .dayNumber(itineraryEntity.getDayNumber())
            .date(itineraryEntity.getDate())
            .activities(itineraryEntity.getActivities().stream().map(ActivityResDto::from)
                .collect(Collectors.toList()))
            .build();

    }
}
