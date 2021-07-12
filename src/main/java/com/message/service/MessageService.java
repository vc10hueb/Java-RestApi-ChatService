package com.message.service;

import com.message.model.Message;
import com.message.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The business logic layer for messages.
 */
@Slf4j
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
        List<Message> messages = new ArrayList<>();
        messageRepository.findAllById(new ArrayList<>(userId)).forEach(messages::add);
        return messages;
    }

    /**
     * Create or update a new message for the user.
     * @param message the message to create or update
     * @return the message populated after the save
     */
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    /**
     * Delete a message for a user. This is a soft delete.
     *
     * @param message the message to delete
     */
    public void deleteMessage(Message message) {
        message.setActive(false);
        messageRepository.save(message);
    }
}
