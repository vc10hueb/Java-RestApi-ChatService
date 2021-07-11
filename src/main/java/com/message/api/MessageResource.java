package com.message.api;

import com.message.model.message.Message;
import com.message.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The message data rest API.
 */
@Slf4j
@RestController
@RequestMapping("/api/message")
@Api(tags = "Message Api")
public class MessageResource {

    @Autowired
    MessageService messageService;

    @GetMapping
    @RequestMapping("/{userId}")
    @ApiOperation("This api call gets a list of the user's messages.")
    @ResponseBody
    public List<Message> getMessages(@PathVariable Integer userId) {
        log.debug("Getting messages for user with Id: {}", userId);
        return messageService.getMessages(userId);
    }

    @GetMapping
    @RequestMapping("/delete/{messageId}")
    @ApiOperation("This api request deletes a message.")
    public void deleteMessage(@PathVariable Integer messageId) {
        log.info("Deleting message with Id: {}", messageId);
        messageService.deleteMessage(messageId);
        log.info("Message deleted.");
    }

    @PostMapping
    @RequestMapping("/createOrUpdate")
    @ApiOperation("This api request will create or update the requested messaged.")
    @ResponseBody
    public Message createOrUpdateMessage(@RequestBody Message message) {
        log.debug("Creating message for user Id: {}", message.getUserId());
        return messageService.createOrUpdateMessage(message);
    }


}
