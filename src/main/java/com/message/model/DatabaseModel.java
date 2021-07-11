package com.message.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * A base class for database models.
 */
@Getter
@AllArgsConstructor
public class DatabaseModel {

    private Integer id;
    private boolean isActive;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
