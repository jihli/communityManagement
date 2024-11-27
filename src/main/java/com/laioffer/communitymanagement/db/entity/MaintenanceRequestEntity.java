package com.laioffer.communitymanagement.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.time.LocalDate;

@Table("MaintenanceRequest")
public record MaintenanceRequestEntity(
        @Id Long id,
        Long userId, // References UserEntity.id
        String description,
        LocalDate requestDate,
        Instant createdAt
) {
}
