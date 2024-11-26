package com.laioffer.communitymanagement.db;

import com.laioffer.communitymanagement.db.entity.DiscussionEntity;

import java.util.List;

public interface DiscussionRepository {
    List<DiscussionEntity> findByAnnouncementId(int Id);
    int save(DiscussionEntity discussion);
}
