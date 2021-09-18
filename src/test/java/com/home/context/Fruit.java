package com.home.context;

import io.cucumber.spring.CucumberTestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(CucumberTestContext.SCOPE_CUCUMBER_GLUE)
public class Fruit {
    String name = "Apple";

    public String getName() {
        return name;
    }

    public void transform(){
        name = "Banana";
    }
}
