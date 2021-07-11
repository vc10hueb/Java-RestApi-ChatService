package com.message.model.user;

import com.message.utils.RepositoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Row mapper for {@link User} objects.
 */
@Component
public class UserRowMapper implements RowMapper<User> {

    @Autowired
    RepositoryUtil repositoryUtil;

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User
                .builder()
                .id(rs.getInt("id"))
                .active(rs.getBoolean("active"))
                .createdAt(repositoryUtil.getNullSafeLocalDateTime(rs, "created_at"))
                .updatedAt(repositoryUtil.getNullSafeLocalDateTime(rs, "updated_at"))
                .id(rs.getInt("user_id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .emailAddress(rs.getString("email_address"))
                .username(rs.getString("username"))
                .password(rs.getString("password"))
                .build();
    }
}
