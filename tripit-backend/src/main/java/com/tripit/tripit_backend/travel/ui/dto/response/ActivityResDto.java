package com.tripit.tripit_backend.travel.ui.dto.response;

import com.tripit.tripit_backend.travel.infra.entity.ActivityEntity;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ActivityResDto {

    private Long activityId;
    private String contentId;
    private LocalDateTime start;
    private LocalDateTime end;

    public static ActivityResDto from(ActivityEntity activityEntity) {
        return ActivityResDto.builder()
            .activityId(activityEntity.getId())
            .contentId(activityEntity.getContentId())
            .start(activityEntity.getStart())
            .end(activityEntity.getEnd())
            .build();
    }
}
