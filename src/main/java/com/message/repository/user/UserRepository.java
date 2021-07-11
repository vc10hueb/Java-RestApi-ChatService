package com.message.repository.user;

import com.message.model.user.User;
import com.message.model.user.UserRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * The CRUD operations for the user data.
 */
@Repository
public class UserRepository {
    @Resource(name = "messageJdbcTemplate")
    private NamedParameterJdbcTemplate messageJdbcTemplate;

    @Resource(name = "userRowMapper")
    private UserRowMapper userRowMapper;

    @Resource(name = "userQueries")
    private UserQueries userQueries;

    /**
     * Read user by username and password.
     *
     * @param username the username
     * @param password the user password
     * @return the user if any match
     */
    public User readUser(String username, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        return messageJdbcTemplate.queryForObject(userQueries.getReadUser(), params, userRowMapper);
    }


    /**
     * Create a new user.
     * @param firstname the user's first name
     * @param lastName the user's last name
     * @param username the user's username
     * @param password the user's password
     * @param emailAddress the user's email address
     * @return the Id of the newly created user
     */
    public int createUser(String firstname, String lastName, String username, String password, String emailAddress) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", firstname);
        params.put("lastName", lastName);
        params.put("username", username);
        params.put("password", password);
        params.put("emailAddress", emailAddress);

        return messageJdbcTemplate.update(userQueries.getCreateUser(), params);
    }

    /**
     * Update a user's username.
     *
     * @param userId the user's id
     * @param username the user's username
     */
    public void updateUser(int userId, String username) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("username", username);
        messageJdbcTemplate.update(userQueries.getUpdateUser(), params);
    }

    /**
     * Delete a user. This is a soft delete.
     *
     * @param userId the user to mark inactive
     */
    public void deleteUser(int userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        messageJdbcTemplate.update(userQueries.getDeleteUser(), params);
    }
}
