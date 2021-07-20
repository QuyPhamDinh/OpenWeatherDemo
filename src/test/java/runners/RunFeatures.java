package runners;

import base.BaseTest;
import cucumber.api.CucumberOptions;


@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json",
        "rerun:target/cucumber-reports/rerun.txt" }, 
        features = "src/test/resources/features",
glue = "steps")
public class RunFeatures extends BaseTest {
}
