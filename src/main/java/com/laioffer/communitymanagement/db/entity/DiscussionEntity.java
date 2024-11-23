package com.laioffer.communitymanagement.db.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


import java.time.Instant;

@Table("discussions")
public record DiscussionEntity(
        @Id Long id,
        String content,
        Long announcementId, // References AnnouncementEntity.id
        Long postedBy, // References UserEntity.id
        Instant createdAt
) {
}
