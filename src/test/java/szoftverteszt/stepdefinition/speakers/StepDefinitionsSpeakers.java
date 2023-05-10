package szoftverteszt.stepdefinition.speakers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import szoftverteszt.factory.WebDriverFactory;
import szoftverteszt.pageobjects.CommunitiesPage;
import szoftverteszt.pageobjects.MainPage;
import szoftverteszt.pageobjects.SpeakersPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class StepDefinitionsSpeakers {

    public static final int SLEEP_TIME_SECONDS = 2;
    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private MainPage mainPage;

    @Autowired
    private SpeakersPage speakersPage;

    @Given("the home page is opened")
    public void communitiesPortalOpened() {
        webDriverFactory.getWebDriver().get("https://wearecommunity.io/");
    }

    @When("the Speakers button is clicked")
    public void iClickTheCommunitiesButton() {
        mainPage.clickSpeakers();
    }
    @Then("the speakers page is opened")
    public void theSpeakersPageIsOpened() {
       Assert.assertTrue(speakersPage.isOpened());
    }
    @When("the Login button is clicked")
    public void iClickTheLoginButton() throws InterruptedException {
        mainPage.clickLogin();
        TimeUnit.SECONDS.sleep(SLEEP_TIME_SECONDS);
    }
    @Then("the login page is opened")
    public void loginPageOpened() {
        Assert.assertTrue(mainPage.isOnLoginPage());
        webDriverFactory.getWebDriver().navigate().back();
    }

    @Then("the searchbar is visible")
    public void searchBarVisible() {
        Assert.assertTrue(speakersPage.isSearchOnPage());
    }

    @Given("the searchbar is clicked")
    public void searchBarClick() {
        speakersPage.searchBarClick();
    }

    @When("{string} is typed in searchbar")
    public void iTypeInSearch(String searchString) {
        speakersPage.searchFor(searchString);
    }

    @Then("{string} card is visible")
    public void iSeeTheCard(String title) throws InterruptedException {

        boolean contain = false;
        List<WebElement> cards = speakersPage.getCards();
        TimeUnit.SECONDS.sleep(SLEEP_TIME_SECONDS);
        for (WebElement card : cards)
        {
            if (card.getText().trim().contains(title))
                contain = true;
        }

        Assert.assertTrue(contain);

    }
    @And("{int} card is visible")
    public void iSeeCard(int count) {
        Assert.assertEquals(count, speakersPage.getCardCountOnPage());
    }



}
