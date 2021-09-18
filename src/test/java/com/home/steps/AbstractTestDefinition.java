package com.home.steps;

import com.home.config.CucumberSpringConfiguration;
import com.home.config.FrameworkContextConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {FrameworkContextConfiguration.class})
public class AbstractTestDefinition {
}
