package com.home.runners;

import com.home.base.BaseTest;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json",
        "rerun:target/cucumber-reports/rerun.txt" }, 
        features = "src/test/resources/features",
        extraGlue = "com/home/steps")
public class RunFeatures extends BaseTest {
}
