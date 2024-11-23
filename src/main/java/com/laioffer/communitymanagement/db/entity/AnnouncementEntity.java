package com.laioffer.communitymanagement.db.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


import java.time.Instant;


@Table("announcements")
public record AnnouncementEntity(
        @Id Long id,
        String title,
        String content,
        Long postedBy, // References UserEntity.id
        Instant createdAt
) {
}
