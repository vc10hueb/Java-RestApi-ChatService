package com.message.service;

import com.message.model.message.Message;
import com.message.model.user.User;
import com.message.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The business logic layer for Users.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageService messageService;

    /**
     * Get a fully populated user.
     *
     * @param username the user's name
     * @param password the user's password
     * @return the user if a matching record is found
     */
    public User getUser(String username, String password) {
        User user = userRepository.readUser(username, password);
        List<Message> messages = messageService.getMessages(user.getId());

        return User.builder()
                .id(user.getId())
                .active(user.isActive())
                .createdAt(user.getCreateAt())
                .updatedAt(user.getUpdatedAt())
                .emailAddress(user.getEmailAddress())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .password(user.getPassword())
                .messages(new ArrayList<>(messages))
                .build();

    }

    /**
     * Create a new user or update an existing one.
     *
     * @param user the user to create
     * @return the user populated with all data
     */
    public User createOrUpdateUser(User user) {
        Integer userId = user.getId();
        LocalDateTime createdAt = user.getCreateAt();
        if ( userId == null) {
            userId = userRepository.createUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getEmailAddress());
            createdAt = LocalDateTime.now();
        } else {
            userRepository.updateUser(userId, user.getUsername());
        }

        return User.builder()
                .id(userId)
                .active(user.isActive())
                .createdAt(createdAt)
                .updatedAt(LocalDateTime.now())
                .emailAddress(user.getEmailAddress())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    /**
     * Delete a user.
     *
     * @param userId the Id of the user
     */
    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }
}
