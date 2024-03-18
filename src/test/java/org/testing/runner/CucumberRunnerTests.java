package org.testing.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.testing.definitions",
        //tags = "@test1",
        plugin = {"pretty",
                "json:target/cucumber-reports/report.json",
                "html:target/cucumber-reports/report.html"})
public class CucumberRunnerTests {
}
