package com.laioffer.communitymanagement.db.chat;

import com.laioffer.communitymanagement.db.ConversationRepository;
import com.laioffer.communitymanagement.db.MessageRepository;
import com.laioffer.communitymanagement.db.entity.ConversationEntity;
import com.laioffer.communitymanagement.db.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        if (!conversationRepository.existsById(conversationId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conversation not found: " + conversationId);
        }
        message = new MessageEntity(
                null,
                conversationId,
                message.senderId(),
                message.content(),
                Instant.now()
        );
        return messageRepository.save(message);
    }

    @PostMapping("/new/messages")
    public MessageEntity createConversationAndSendMessage(@RequestBody MessageEntity message) {
        if (message.senderId() == null || message.content() == null || message.content().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sender ID and message content cannot be null or empty.");
        }
        ConversationEntity newConversation = new ConversationEntity(
                null,
                message.senderId(),
                1L,
                message.content(),
                Instant.now(),
                Instant.now(),
                Instant.now()
        );
        conversationRepository.save(newConversation);
        MessageEntity newMessage = new MessageEntity(
                null,
                newConversation.conversationId(),
                message.senderId(),
                message.content(),
                Instant.now()
        );
        return messageRepository.save(newMessage);
    }
}
