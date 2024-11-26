package com.laioffer.communitymanagement.discussion;

import com.laioffer.communitymanagement.db.entity.DiscussionEntity;

import java.util.List;

public interface DiscussionService {
    List<DiscussionEntity> getDiscussionsByAnnouncementId(int announcementId);
    void createDiscussion(int announcementId, DiscussionEntity discussion);
}
