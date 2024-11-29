package com.laioffer.communitymanagement.db;

import com.laioffer.communitymanagement.db.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {

    // 查询指定会话的所有消息，按时间升序
    List<MessageEntity> findByConversationIdOrderByTimestampAsc(Long conversationId);
}
