package szoftverteszt.stepdefinition.calendar;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import szoftverteszt.factory.WebDriverFactory;
import szoftverteszt.pageobjects.CalendarPage;
import szoftverteszt.pageobjects.CommunitiesPage;
import szoftverteszt.pageobjects.MainPage;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class StepDefinitionsCalendar {


    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private MainPage mainPage;

    @Autowired
    private CalendarPage calendarPage;

    @Given("the home page is opened")
    public void communitiesPortalOpened() {
        webDriverFactory.getWebDriver().get("https://wearecommunity.io/");
    }

    @And("the Calendar button is clicked")
    public void iClickTheCalendarButton() throws InterruptedException {
        mainPage.clickCalendar();
        TimeUnit.SECONDS.sleep(4);
    }

    @Then("the calendar page is opened")
    public void calendarPageIsOpened() {

        Assert.assertTrue(calendarPage.isOpened());
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

    @Then("{string} is shown")
    public void eventsShown(String string) {
        Assert.assertEquals(string, calendarPage.isDisplayTitleBar());
    }

    @Then("the calendar is shown")
    public void calendarShown() {
        Assert.assertTrue(calendarPage.calendarIsDisplay());
    }

    @When("the Month button is clicked")
    public void monthButtonClick()  {
        calendarPage.monthButtonClick();
    }

    @Then("the days of the month are visible")
    public void daysVisible() {
        calendarPage.dayOfTheMonthVisible();
    }

    @When("the Week button is clicked")
    public void weekButtonClick()  {
        calendarPage.weekButtonClick();
    }

    @Then("the days of the week are visible")
    public void daysWeekVisible() {
        calendarPage.dayOfTheWeekVisible();
    }

    @And("the hours of the day are visible")
    public void hoursWeekVisible() {
        calendarPage.hourInWeekVisible();
    }

    @When("the Day button is clicked")
    public void dayButtonClick()  {
        calendarPage.dayButtonClick();
    }

    @Then("the hours of the day are visible in day mode")
    public void daysHourVisible() {
        calendarPage.hourInDayVisible();
    }

    @When("the List button is clicked")
    public void listButtonClick()  {
        calendarPage.listButtonClick();
    }

    @Then("the days of the month are visible in list")
    public void daysListVisible() {
        calendarPage.listDayVisible();
    }

    @And("the event list is visible")
    public void eventListVisible() {
        calendarPage.eventListVisible();
    }

    @When("the {string} button is clicked")
    public void calTypeButtonClick(String string)  {
        if(string.equals("Month")){
            calendarPage.monthButtonClick();
        }
        if(string.equals("Day")){
            calendarPage.dayButtonClick();
        }
        if(string.equals("List")){
            calendarPage.listButtonClick();
        }
        if(string.equals("Week")){
            calendarPage.weekButtonClick();
        }
    }
    @And("{string} is clicked")
    public void eventListVisible(String string) throws InterruptedException {
        calendarPage.clickToEvent(string);
        TimeUnit.SECONDS.sleep(2);
    }

    @Then("the {string} is in the sidemenu")
    public void sidemenuName(String string) {
        Assert.assertEquals(string, calendarPage.eventNameText());
    }


}
