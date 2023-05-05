package szoftverteszt.stepdefinition.communities;

import szoftverteszt.factory.WebDriverFactory;
import szoftverteszt.pageobjects.CommunitiesPage;
import szoftverteszt.pageobjects.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class StepDefinitionsCommunities {


    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private MainPage mainPage;

    @Autowired
    private CommunitiesPage communitiesPage;

    @Given("the home page is opened")
    public void communitiesPortalOpened() {
        webDriverFactory.getWebDriver().get("https://wearecommunity.io/");
    }

    @When("the Communities button is clicked")
    public void iClickTheCommunitiesButton() {
        mainPage.clickCommunities();
    }



}
