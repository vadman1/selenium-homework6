package org.example.framework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"org.example.framework.utils.MyAllureListener"},
        glue = "org/example/framework/steps",
        features = "src/test/resources",
        tags = {"@firstTest"}
)
public class CucumberRunner {
}
