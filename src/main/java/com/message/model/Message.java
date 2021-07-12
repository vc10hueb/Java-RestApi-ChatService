package com.message.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A representation of the message database model.
 */
@Data
@Entity
@Table(name = "message")
@ApiModel
public class Message implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @Column(name = "user_id")
    @NotNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int userId;

    @Column(name = "message")
    @NotNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Size(min = 1, max = 500, message
            = "A message must be between 1 and 500 characters.")
    private String message;

    @Column(name = "active")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isActive;

    @Column(name = "created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createAt;

    @Column(name = "updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime updatedAt;
}
