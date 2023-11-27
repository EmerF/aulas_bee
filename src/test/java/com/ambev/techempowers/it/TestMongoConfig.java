package com.ambev.techempowers.it;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.ambev.techempowers.repository")
@ComponentScan(basePackages = "com.ambev.techempowers")
public class TestMongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        // You can customize the connection details for testing
        String testMongoUri = "mongodb://0.0.0.0:27017/meumongo";
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(testMongoUri));
    }
}
