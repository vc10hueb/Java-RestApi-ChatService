package com.message.repository.user;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * User CRUD queries set via properties.
 */
@Data
@Component
public class UserQueries {

    @Value("INSERT INTO user(username,password,first_name,last_name,email_address)"
            + " values(:username,:password,:firstName,:lastName,:emailAddress)")
    private String createUser;

    @Value("SELECT * FROM user WHERE username = :username AND password = :password ")
    private String readUser;

    @Value("UPDATE user SET username = :username WHERE id = :userId")
    private String updateUser;

    @Value("UPDATE user SET active = false WHERE id = :userId")
    private String deleteUser;
}
