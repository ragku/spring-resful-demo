package org.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ragku.restful.config.SpringConfig;

@SpringBootApplication
public class Application extends SpringConfig{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
