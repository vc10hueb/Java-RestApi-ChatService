package com.message.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean("exampleCache")
    public String exampleCache() {
        return "Hello World!";
    }
}
