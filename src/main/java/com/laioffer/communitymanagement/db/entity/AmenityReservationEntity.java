package com.laioffer.communitymanagement.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Table("AmenityReservations")
public record AmenityReservationEntity(
        @Id Long id,
        Long userId, // References UserEntity.id
        Long amenityId, // References AmenityEntity.id
        LocalDate reservationDate,
        LocalTime reservationTime,
        Instant createdAt
) {
}
