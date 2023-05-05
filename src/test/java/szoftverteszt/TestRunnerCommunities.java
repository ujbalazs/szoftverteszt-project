package szoftverteszt;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/communities.feature",
    glue = {"szoftverteszt.stepdefinition.communities", "szoftverteszt.configuration"},
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunnerCommunities {
}
