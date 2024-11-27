package com.laioffer.communitymanagement.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("Amenities")
public record AmenityEntity(
        @Id Long id,
        String amenityName,
        String imageUrl
) {
}
