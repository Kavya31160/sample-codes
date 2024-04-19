package com.stackroute.samplerestbasic.config;

import jakarta.activation.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CustomDataSourceConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        return new CustomDataSource();
    }
}
