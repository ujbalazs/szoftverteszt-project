package szoftverteszt;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/speakers.feature",
    glue = {"szoftverteszt.stepdefinition.speakers", "szoftverteszt.configuration"},
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunnerSpeakers {
}
