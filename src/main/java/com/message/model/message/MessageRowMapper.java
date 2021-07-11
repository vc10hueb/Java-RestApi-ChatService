package com.message.model.message;

import com.message.utils.RepositoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Row mapper for {@link Message} objects.
 */
@Component
public class MessageRowMapper implements RowMapper<Message> {

    @Autowired
    RepositoryUtil repositoryUtil;

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Message
                .builder()
                .id(rs.getInt("id"))
                .active(rs.getBoolean("active"))
                .createdAt(repositoryUtil.getNullSafeLocalDateTime(rs, "created_at"))
                .updatedAt(repositoryUtil.getNullSafeLocalDateTime(rs, "updated_at"))
                .userId(rs.getInt("user_id"))
                .message(rs.getString("message"))
                .build();
    }
}