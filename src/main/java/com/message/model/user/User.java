package com.message.model.user;

import com.message.model.DatabaseModel;
import com.message.model.message.Message;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A representation of the User data model.
 */
@Getter
public class User extends DatabaseModel {


    @NotNull
    @Size(min = 10, max = 100, message
            = "A first name must be between 1 and 100 characters.")
    private String firstName;
    @NotNull
    @Size(min = 10, max = 100, message
            = "A last name must be between 1 and 100 characters.")
    private String lastName;
    @NotNull
    @Size(min = 10, max = 100, message
            = "An email address must be between 1 and 100 characters.")
    @Email
    private String emailAddress;
    @NotNull
    @Size(min = 10, max = 100, message
            = "A username must be between 1 and 100 characters.")
    private String username;
    @NotNull
    @Size(min = 10, max = 100, message
            = "A password must be between 1 and 100 characters.")
    private String password;

    private ArrayList<Message> messages;

    @Builder
    public User (String firstName, String lastName, String emailAddress, String username, String password,
                 int id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean active, ArrayList<Message> messages) {
        super(id, active, createdAt, updatedAt);
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.messages = messages;
    }
}
