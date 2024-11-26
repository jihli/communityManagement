package com.laioffer.communitymanagement.db.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.time.Instant;
import java.time.LocalDateTime;


@Table("announcements")
public record AnnouncementEntity(
        @Id Integer id,
        String title,
        String content,
        @Column("posted_by") Integer postedBy,
        @Column("created_at") LocalDateTime createdAt
) {

}
