package com.message.repository.message;

import com.message.model.message.Message;
import com.message.model.message.MessageRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The CRUD operations for the message data.
 */
@Repository
public class MessageRepository {

    @Resource(name = "messageJdbcTemplate")
    private NamedParameterJdbcTemplate messageJdbcTemplate;

    @Resource(name = "messageRowMapper")
    private MessageRowMapper messageRowMapper;

    @Resource(name = "messageQueries")
    private MessageQueries messageQueries;

    /**
     * Read the messages for a user.
     *
     * @param userId a user Id
     * @return a list of messages associated with the user
     */
    public List<Message> readMessages(int userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return messageJdbcTemplate.query(messageQueries.getReadMessages(), params, messageRowMapper);
    }

    /**
     * Create a message for a user.
     *
     * @param userId a user Id
     * @param message a message
     *
     * @return the Id of the newly created record
     */
    public int createMessage(int userId, String message) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("message", message);
        return messageJdbcTemplate.update(messageQueries.getCreateMessage(), params);
    }

    /**
     * Update a message for a user.
     *
     * @param messageId the message id
     * @param message the new message to save
     */
    public void updateMessage(int messageId, String message) {
        Map<String, Object> params = new HashMap<>();
        params.put("messageId", messageId);
        params.put("message", message);
        messageJdbcTemplate.update(messageQueries.getUpdateMessage(), params);
    }

    /**
     * Delete a message for a user. This is a soft delete.
     *
     * @param messageId the message Id to mark inactive
     */
    public void deleteMessage(int messageId) {
        Map<String, Object> params = new HashMap<>();
        params.put("messageId", messageId);
        messageJdbcTemplate.update(messageQueries.getDeleteMessage(), params);
    }
}
