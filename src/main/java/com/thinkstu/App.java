package com.thinkstu;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.servlet.support.*;
import org.springframework.scheduling.annotation.*;

@SpringBootApplication
@EnableScheduling
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
