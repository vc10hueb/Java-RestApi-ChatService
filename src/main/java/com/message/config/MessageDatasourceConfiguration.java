package com.message.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Message datasource config.
 */
@Slf4j
@Configuration
public class MessageDatasourceConfiguration {

    private Environment environment;

    @Autowired
    public MessageDatasourceConfiguration(Environment environment) {
        this.environment = environment;
    }

    /**
     * Setup the message data source.
     *
     * @return the datasource
     */
    @Bean(name = "messageDataSource")
    public DataSource messageDataSource() {
        DataSource dataSource = null;
        String messageJndiDatasource = environment.getProperty("spring.datasource.jndi-name/jdbc/message");
        if (messageJndiDatasource != null && !messageJndiDatasource.isEmpty()) {
            log.info("Configuring message data source via JNDI.");
            JndiDataSourceLookup lookup = new JndiDataSourceLookup();
            dataSource = lookup.getDataSource(messageJndiDatasource);
        } else {
            log.info("Configuring message data source via properties.");
            DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName(environment.getProperty("spring.datasource.driver-class-name"));
            dataSourceBuilder.url(environment.getProperty("spring.datasource.jdbc-url"));
            dataSourceBuilder.username(environment.getProperty("spring.datasource.username"));
            dataSourceBuilder.password(environment.getProperty("spring.datasource.password"));
            return dataSourceBuilder.build();
        }
        return dataSource;
    }

    /**
     * Create the message transaction manager.
     *
     * @return
     */
    @Bean(name = "messageTransactionManager")
    public PlatformTransactionManager messageTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(messageDataSource());
        return transactionManager;

    }
    /**
     * Create the message JDBC template.
     *
     * @return JDBC template
     */
    @Bean(name = "messageDataSource")
    public NamedParameterJdbcTemplate messageJdbcTemplate() {
        return new NamedParameterJdbcTemplate(messageDataSource());
    }
}
