package szoftverteszt.stepdefinition.communities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import szoftverteszt.factory.WebDriverFactory;
import szoftverteszt.pageobjects.CommunitiesPage;
import szoftverteszt.pageobjects.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


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

    @And("the Communities button is clicked")
    public void iClickTheCommunitiesButton() {
        mainPage.clickCommunities();
    }

    @Then("the communities page is opened")
    public void comPageOpened() {
        Assert.assertTrue(communitiesPage.isOpened());
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

    @Then("the searchbar is visible")
    public void searchBarVisible() {
        Assert.assertTrue(communitiesPage.isSearchOnPage());
    }

    @Given("the searchbar is clicked")
    public void searchBarClick() {
        communitiesPage.searchBarClick();
    }

    @When("{string} is typed in searchbar")
    public void iTypeInSearch(String searchString) {
        communitiesPage.searchFor(searchString);
    }

    @Then("{string} card is visible")
    public void iSeeTheCard(String title) throws InterruptedException {
        /*new WebDriverWait(webDriverFactory.getWebDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(communitiesPage.getCard(), title));*/

            boolean contain = false;
            List<WebElement> cards = communitiesPage.getCards();
            TimeUnit.SECONDS.sleep(2);
            for (WebElement card : cards)
            {
                if (card.getText().trim().contains(title))
                    contain = true;
            }

            Assert.assertTrue(contain);

    }

    @Given("the Location button is clicked")
    public void locationClick() {
        communitiesPage.locationDropdownClick();
    }

    @And("searchbar is empty")
    public void searchEmpty() {
        Assert.assertTrue(communitiesPage.searchIsEmpty());
    }

    @When("just {string} is selected")
    public void locSearch(String location) throws InterruptedException {
        communitiesPage.searchLocation(location);
        TimeUnit.SECONDS.sleep(1);
        communitiesPage.locationCheckboxClick();
        TimeUnit.SECONDS.sleep(1);
    }



}
