package com.laioffer.communitymanagement.db.repository;

import com.laioffer.communitymanagement.db.entity.ConversationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConversationRepository extends CrudRepository<ConversationEntity, Long> {

    // 查询指定用户参与的所有会话
    List<ConversationEntity> findByUserId(Long userId);
}
