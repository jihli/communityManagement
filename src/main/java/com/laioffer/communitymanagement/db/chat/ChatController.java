package com.laioffer.communitymanagement.db.chat;

import com.laioffer.communitymanagement.db.entity.ConversationEntity;
import com.laioffer.communitymanagement.db.entity.MessageEntity;
import com.laioffer.communitymanagement.db.repository.ConversationRepository;
import com.laioffer.communitymanagement.db.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<ConversationEntity> getUserConversations(@RequestParam Long userId) {
        return conversationRepository.findByUserId(userId);
    }

    @GetMapping("/{conversationId}/messages")
    public List<MessageEntity> getConversationMessages(@PathVariable Long conversationId) {
        return messageRepository.findByConversationIdOrderByTimestampAsc(conversationId);
    }

    @PostMapping("/{conversationId}/messages")
    public MessageEntity sendMessage(@PathVariable Long conversationId, @RequestBody MessageEntity message) {
        // 设置会话 ID 和时间戳
        message = new MessageEntity(
                null,
                conversationId,
                message.senderId(),
                message.content(),
                Instant.now()
        );
        return messageRepository.save(message);
    }
}
