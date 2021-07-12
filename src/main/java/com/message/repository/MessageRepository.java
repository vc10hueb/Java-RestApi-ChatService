package com.message.repository;

import com.message.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Message CRUD queries set via properties.
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {


}
