package com.message.model.message;

import com.message.model.DatabaseModel;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * A representation of the message database model.
 */
@Getter
public class Message extends DatabaseModel {

    @NotNull
    private int userId;

    @NotNull
    @Size(min = 1, max = 500, message
            = "A message must be between 1 and 500 characters.")
    private String message;

    @Builder
    public Message(int userId, String message, int id, boolean active, LocalDateTime createdAt,
                   LocalDateTime updatedAt) {
        super(id, active, createdAt, updatedAt);
        this.userId = userId;
        this.message = message;

    }
}
