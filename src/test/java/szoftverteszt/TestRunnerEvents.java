package szoftverteszt;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/events.feature",
    glue = {"szoftverteszt.stepdefinition.events", "szoftverteszt.configuration"},
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunnerEvents {
}
