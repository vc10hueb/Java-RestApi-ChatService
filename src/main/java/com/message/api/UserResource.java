package com.message.api;

import com.message.model.User;
import com.message.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The user data rest API.
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
@Api(tags = "User Api")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping
    @ApiOperation("This api call will get a user for login information (username, password).")
    @ResponseBody
    public User getUser(String username, String password) {
        log.debug("Getting user with username: {}", username);
        return userService.getUser(username, password);
    }

    @GetMapping
    @RequestMapping("/delete/{userId}")
    @ApiOperation("This api call will delete a user.")
    public void deleteUser(@RequestBody User user) {
        log.debug("Deleting user with Id: {}", user.getId());
        userService.deleteUser(user);
        log.debug("User deleted.");
    }

    @PostMapping
    @RequestMapping("/createOrUpdate")
    @ApiOperation("This api request will create or update the requested user.")
    @ResponseBody
    public User getUser(@RequestBody User user) {
        log.debug("Creating new user with username: {}", user.getUsername());
        return userService.saveUser(user);
    }



}
