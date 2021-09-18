package com.home.steps;

import com.home.context.Fruit;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class CommonCucumberSteps extends AbstractTestDefinition {

    private static final Logger logger = LogManager.getLogger(CommonCucumberSteps.class);

    @Autowired
    private Fruit fruit;

    @And("the fruit is Banana")
    public void theFruitIsBanana() {
        logger.info("init value: " +fruit.getName());
        fruit.transform();
        logger.info("transformed value: " +fruit.getName());
    }
}
