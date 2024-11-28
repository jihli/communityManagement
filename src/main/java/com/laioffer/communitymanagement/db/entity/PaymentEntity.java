package com.laioffer.communitymanagement.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("payment")
public record PaymentEntity(
        @Id String id,
        Long user_id,
        Long paymentId,
        Long amount,
        String currency,
        String Status,
        String description,
        Instant createdAt,
        Instant updatedAt
) {
}