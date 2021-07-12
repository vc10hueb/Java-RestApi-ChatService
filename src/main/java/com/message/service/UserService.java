package com.message.service;

import com.message.model.User;
import com.message.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The business logic layer for Users.
 */
@Slf4j
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
        Optional<User> userOptional = userRepository.readUser(username, password);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setMessages(new ArrayList<>(messageService.getMessages(user.getId())));
            return user;
        }
        throw new IllegalStateException("The user name and password are invalid.");
    }

    /**
     * Create or update a user.
     *
     * @param user the user to create or update
     * @return the user populated after the save
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Delete a user.
     *
     * @param user the user to delete
     */
    public void deleteUser(User user) {
        user.setActive(false);
        userRepository.save(user);
    }
}
