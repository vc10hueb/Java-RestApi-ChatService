package com.message.service;

import com.message.model.message.Message;
import com.message.repository.message.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The business logic layer for messages.
 */
@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    /**
     * Get a user's messages.
     *
     * @param userId the user's Id
     * @return the list of messages for the user
     */
    public List<Message> getMessages(int userId) {
        return messageRepository.readMessages(userId);
    }

    /**
     * Create a new message for user.
     * @param message the message to create.
     * @return the message with the Id populated from the database
     */
    public Message createOrUpdateMessage(Message message) {
        Integer messageId = message.getId();
        LocalDateTime createdAt = message.getCreateAt();
        if ( messageId == null) {
            messageId = messageRepository.createMessage(message.getUserId(), message.getMessage());
            createdAt = LocalDateTime.now();
        } else {
            messageRepository.updateMessage(message.getId(), message.getMessage());
        }
        return Message.builder()
                .id(messageId)
                .active(true)
                .createdAt(createdAt)
                .updatedAt(LocalDateTime.now())
                .userId(message.getUserId())
                .message(message.getMessage()).build();
    }

    /**
     * Delete a message for a user.
     *
     * @param messageId the Id of the message to delete
     */
    public void deleteMessage(int messageId) {
        messageRepository.deleteMessage(messageId);
    }
}
