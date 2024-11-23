package com.laioffer.communitymanagement.db.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;


@Table("users")
public record UserEntity(
        @Id Long id,
        String username,
        String password,
        String role, // e.g., RESIDENT, ADMIN
        Instant createdAt
) {
}
