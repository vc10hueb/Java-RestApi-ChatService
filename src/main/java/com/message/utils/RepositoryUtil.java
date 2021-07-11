package com.message.utils;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * A class for some common functions shared by
 */
@Component
public class RepositoryUtil {

    public LocalDateTime getNullSafeLocalDateTime(ResultSet rs, String columnName) throws SQLException {
        return LocalDateTime.from(rs.getDate(columnName) != null ? rs.getDate(columnName).toInstant() : null);
    }
}
