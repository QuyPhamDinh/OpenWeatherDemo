package com.home.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@EnableRetry
@Configuration
@ComponentScan({
        "com.home"
})
//@PropertySource("application.properties")
public class CucumberSpringConfiguration {
}
