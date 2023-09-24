package com.mjc.school.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableJpaAuditing
@EnableAspectJAutoProxy
@SpringBootApplication
@ComponentScan("com.mjc.school.*")
@EnableTransactionManagement
@EntityScan(basePackages = "com.mjc.school.repository.model")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
