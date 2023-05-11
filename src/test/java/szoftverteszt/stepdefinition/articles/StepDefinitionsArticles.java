package szoftverteszt.stepdefinition.articles;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import szoftverteszt.factory.WebDriverFactory;
import szoftverteszt.pageobjects.ArticlesPage;
import szoftverteszt.pageobjects.CommunitiesPage;
import szoftverteszt.pageobjects.MainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class StepDefinitionsArticles {

    public static final int SLEEP_TIME_SECONDS = 2;
    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private MainPage mainPage;

    @Autowired
    private ArticlesPage articlesPage;

    @Given("the home page is opened")
    public void communitiesPortalOpened() {
        webDriverFactory.getWebDriver().get("https://wearecommunity.io/");
    }

    @When("the Articles button is clicked")
    public void iClickTheArticlesButton() {
        mainPage.clickArticles();
    }
    @Then("the articles page is opened")
    public void theArticlesPageIsOpened() {Assert.assertTrue(articlesPage.isOpened());}
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
        Assert.assertTrue(articlesPage.isSearchOnPage());
    }

    @Given("the More filters button is clicked")
    public void morefilterClick() {
        articlesPage.moreFilterClick();
    }

    @Given("the searchbar is clicked")
    public void searchBarClick() {
        articlesPage.searchBarClick();
    }

    @When("{string} is typed in searchbar")
    public void iTypeInSearch(String searchString) {
        articlesPage.searchFor(searchString);
    }

    @And("the Language button is clicked")
    public void langClick() {
        articlesPage.languageClick();
    }
    @When("Hungarian is selected")
    public void hunSelect() {
        articlesPage.hunClick();
    }

    @Then("21 card is visible")
    public void huEpamCards() {
        Assert.assertEquals(21, articlesPage.getCardCountFromResultNumber());
    }

    @Then("205 card is visible")
    public void russianCards() {
        Assert.assertEquals(205, articlesPage.getCardCountFromResultNumber());
    }

//    @Then("{int} card is visible")
//    public void cardIsVisible(int count) {
//        Assert.assertEquals(count, articlesPage.getCardCountFromResultNumber());
//    }
    @When("Russian is selected")
    public void ruSelect() {
        articlesPage.ruClick();
    }

    @And("the Date till button is clicked")
    public void dateTillClick() {
        articlesPage.dateTillClick();
    }
    @When("the Author button is clicked")
    public void theAuthorButtonIsClicked() { articlesPage.authorClick(); }

    @And("{string} is typed in")
    public void isTypedIn(String searchString) throws InterruptedException {
        articlesPage.searchForAuthor(searchString);
    }

    @When("05\\/11\\/2023 is selected")
    public void date11Click() {
        articlesPage.date11Click();
    }

    @And("{int} cards is visible")
    public void cardsIsVisible(int count) {
        Assert.assertEquals(count, articlesPage.getCardCountFromResultNumber());
    }

    @Then("{string} card is visible")
    public void iSeeTheCard(String title) throws InterruptedException {
        boolean contain = false;
        List<WebElement> cards = articlesPage.getCards();
        TimeUnit.SECONDS.sleep(SLEEP_TIME_SECONDS);
        for (WebElement card : cards)
        {
            if (card.getText().trim().contains(title))
                contain = true;
        }

        Assert.assertTrue(contain);

    }

    @And("{string} checkbox is clicked")
    public void checkboxIsClicked(String string) {
        articlesPage.clickCheckBox();
    }
}
