package szoftverteszt.stepdefinition.events;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import szoftverteszt.factory.WebDriverFactory;
import szoftverteszt.pageobjects.EventsPage;
import szoftverteszt.pageobjects.MainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class StepDefinitionsEvents {


    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private MainPage mainPage;

    @Autowired
    private EventsPage eventsPage;

    @Given("the home page is opened")
    public void eventsPortalOpened() {
        webDriverFactory.getWebDriver().get("https://wearecommunity.io/");
    }

    @When("the Events button is clicked")
    public void iClickTheEventsButton() {
        mainPage.clickEvents();
    }

    @Then("the events page is opened")
    public void comPageOpened() {
        Assert.assertTrue(eventsPage.isOpened());
    }

    @When("the Login button is clicked")
    public void iClickTheLoginButton() throws InterruptedException {
        mainPage.clickLogin();
        TimeUnit.SECONDS.sleep(2);
    }

    @Then("the login page is opened")
    public void loginPageOpened() {
        Assert.assertTrue(mainPage.isOnLoginPage());
        webDriverFactory.getWebDriver().navigate().back();
    }

    @When("the search icon is clicked")
    public void searchIconClicked() {
        eventsPage.clickSearchIcon();
    }

    @Then("the searchbar in the header is visible")
    public void isSearchBarVisible() {
        Assert.assertTrue(eventsPage.isHeaderSearchActive());
    }

    @Given("the searchbar is clicked")
    public void searchBarClick() {
        eventsPage.searchBarClick();
    }

    @When("{string} is typed in searchbar")
    public void iTypeInSearch(String searchString) {
        eventsPage.searchFor(searchString);
    }

    @Then("{string} card is visible")
    public void iSeeTheCard(String title) throws InterruptedException {
        boolean contain = false;
        List<WebElement> cards = eventsPage.getCards();
        TimeUnit.SECONDS.sleep(2);
        for (WebElement card : cards)
        {
            if (card.getText().trim().contains(title))
                contain = true;
        }

        Assert.assertTrue(contain);

    }

    @Given("the More filters button is clicked")
    public void morefilterClick() {
        eventsPage.moreFilterClick();
    }

    @And("the Language button is clicked")
    public void langClick() {
        eventsPage.languagegClick();
    }

    @When("Hungarian is selected")
    public void hunSelect() {
        eventsPage.hunClick();
    }

    @And("English is selected")
    public void engSelect() throws InterruptedException {
        eventsPage.engClick();
        TimeUnit.SECONDS.sleep(2);

    }
    @Then("69 card is visible")
    public void cardsHUnEngVisible() {
        Assert.assertEquals(69, eventsPage.getCardCountFromUpcomingNumber());
    }

    @Given("the More filters button is clicked again")
    public void morefilterClickAgain() {
        eventsPage.moreFilterClick();
    }

    @And("the Date till button is clicked")
    public void dateTillClick() {
        eventsPage.dateTillClick();
    }

    @When("05\\/11\\/2023 is selected")
    public void date11Click() {
        eventsPage.date11Click();
    }

    @Then("5953 card is visible")
    public void cardNumberCheck() {
        Assert.assertEquals(5953, eventsPage.getCardCountFromPastNumber());
    }

    @Given("the Location button is clicked")
    public void locationClick() {
        eventsPage.locationDropdownClick();
    }

    @And("Hungary is selected")
    public void hungarySelect() {
        eventsPage.hungaryLocationClick();
    }

    @When("the Past events button is clicked")
    public void pastEventsClick() {
        eventsPage.pastEventsTabClick();
    }

    @Then("94 card is visible")
    public void cardsPastEventsVisible() {
        Assert.assertEquals(94, eventsPage.getCardCountFromPastNumber());
    }

    @Then("{string} specific card is visible")
    public void iSeeTheCardSpecific(String title) throws InterruptedException {
        boolean contain = false;
        List<WebElement> cards = eventsPage.getCards();
        TimeUnit.SECONDS.sleep(2);
        for (WebElement card : cards)
        {
            if (card.getText().trim().contains(title))
                contain = true;
        }

        Assert.assertTrue(contain);

    }

    @Given("the Location button is clicked again")
    public void locationClickAgain() {
        eventsPage.locationDropdownClick();
    }

    @And("Hungary is selected again")
    public void hungarySelectAgain() {
        eventsPage.hungaryLocationClick();
    }

    @When("the Upcoming events button is clicked")
    public void upcomingEventsClick() {
        eventsPage.upcomingEventsTabClick();
    }

    @Then("\"Coolest Project 2023 tavasz\" upcoming event card is visible")
    public void searchedCardVisible() {
        Assert.assertTrue(eventsPage.searchedCard());
    }

}
