package com.message.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A representation of the User data model.
 */
@Data
@Entity
@Table(name = "user_info")
@ApiModel
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @Column(name =  "first_name")
    @NotNull
    @Size(min = 10, max = 100, message
            = "A first name must be between 1 and 100 characters.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(min = 10, max = 100, message
            = "A last name must be between 1 and 100 characters.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @Column(name = "email_address")
    @NotNull
    @Size(min = 10, max = 100, message
            = "An email address must be between 1 and 100 characters.")
    @Email
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String emailAddress;

    @Column(name = "username")
    @NotNull
    @Size(min = 10, max = 100, message
            = "A username must be between 1 and 100 characters.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String username;

    @Column(name = "password")
    @NotNull
    @Size(min = 10, max = 100, message
            = "A password must be between 1 and 100 characters.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @Column(name = "active")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isActive;

    @Column(name = "created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createAt;

    @Column(name = "updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime updatedAt;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<Message> messages;

}
