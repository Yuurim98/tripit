package com.tripit.tripit_backend.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    protected LocalDateTime deletedAt;

//    @CreatedBy
//    @Column(updatable = false)
//    private Long createdBy;
//
//    // 수정자
//    @LastModifiedBy
//    private Long updatedBy;
//
//    // 삭제자
//    protected Long deletedBy;

}
