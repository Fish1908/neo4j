package com.project_management.shoppingweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication
@EnableNeo4jRepositories("com.project_management.shoppingweb.repository")

public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

