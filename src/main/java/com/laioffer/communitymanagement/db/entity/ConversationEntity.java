package com.laioffer.communitymanagement.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("Conversations")
public record ConversationEntity(
        @Id Long conversationId,
        Long userId, // References UserEntity.id
        Long adminId, // References UserEntity.id
        String lastMessage,
        Instant lastTimestamp,
        Instant createdAt,
        Instant updatedAt
) {
}
