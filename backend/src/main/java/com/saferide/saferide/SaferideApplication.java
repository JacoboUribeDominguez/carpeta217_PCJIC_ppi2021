package com.saferide.saferide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.saferide.saferide"})
@EntityScan("com.saferide.saferide")
@EnableJpaRepositories("com.saferide.saferide")
public class SaferideApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaferideApplication.class, args);
    }

}
