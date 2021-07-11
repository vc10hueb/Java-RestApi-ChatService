package com.message.repository.message;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Message CRUD queries set via properties.
 */
@Data
@Component
public class MessageQueries {

    @Value("INSERT INTO message(user_id, message) VALUES(:userId, :message)")
    private String createMessage;

    @Value("SELECT * FROM message WHERE user_id = :userId")
    private String readMessages;

    @Value("UPDATE message set message = :message WHERE id = :messageId")
    private String updateMessage;

    @Value("UPDATE message set active = false where id = :messageId")
    private String deleteMessage;
}
