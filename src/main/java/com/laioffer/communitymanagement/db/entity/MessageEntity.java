package com.laioffer.communitymanagement.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("Messages")
public record MessageEntity(
        @Id Long messageId,
        Long conversationId, // References ConversationEntity.conversationId
        Long senderId, // References UserEntity.id
        String content,
        Instant timestamp
) {
}
