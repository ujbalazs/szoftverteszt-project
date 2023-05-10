package szoftverteszt.pageobjects;

import org.openqa.selenium.By;
import szoftverteszt.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import static java.lang.Integer.parseInt;

@Component
public class CalendarPage extends CommonPageObject {

    @FindBy(xpath = "//h1[normalize-space()='Events Calendar']")
    private WebElement titleBar;

    @FindBy(xpath = "//div[contains(@class,'evnt-calendar-table')]")
    private WebElement calendar;

    @FindBy(xpath = "//button[normalize-space()='Month']")
    private WebElement monthButton;

    @FindBy(xpath = "//button[normalize-space()='Week']")
    private WebElement weekButton;

    @FindBy(xpath = "//button[normalize-space()='Day']")
    private WebElement dayButton;

    @FindBy(xpath = "//button[normalize-space()='List']")
    private WebElement listButton;

    @FindBy(xpath = "//span[contains(@class,'fc-day-number')]")
    private WebElement dayInMonth;

    @FindBy(xpath = "//span[contains(@class,'fc-custom-day')]")
    private WebElement dayInWeek;

    @FindBy(xpath = "//td[contains(@class,'fc-axis')]")
    private WebElement hourInWeek;

    @FindBy(xpath = "//td[contains(@class,'fc-time')]")
    private WebElement hourInDay;

    @FindBy(xpath = "//span[contains(@class,'fc-list-heading-main')]")
    private WebElement dayInList;

    @FindBy(xpath = "//tr[contains(@class,'fc-list-item')]")
    private WebElement listItem;

    @FindBy(xpath = "//div[contains(@class,'evnt-event-name')]")
    private WebElement eventName;


    public CalendarPage(WebDriverFactory factory) {
        super(factory);
    }

    public boolean isOpened() {
        return titleBar.isDisplayed();
    }

    public boolean calendarIsDisplay() {
        return calendar.isDisplayed();
    }

    public String isDisplayTitleBar() {
        return titleBar.getText();
    }
    public void monthButtonClick() {
        monthButton.click();
    }

    public void dayButtonClick() {
        dayButton.click();
    }

    public void dayOfTheMonthVisible() {
        dayInMonth.isDisplayed();
    }

    public void weekButtonClick() {
        weekButton.click();
    }

    public void listButtonClick() {
        listButton.click();
    }

    public void listDayVisible() {
        dayInList.isDisplayed();
    }

    public void eventListVisible() {
        listItem.isDisplayed();
    }

    public void dayOfTheWeekVisible() {
        dayInWeek.isDisplayed();
    }

    public void hourInWeekVisible() {
        hourInWeek.isDisplayed();
    }

    public void hourInDayVisible() {
        hourInDay.isDisplayed();
    }

    public void clickToEvent(String eventName) {

        driver.findElement(By.xpath("//*[normalize-space(text())='"+eventName+"']")).click();
    }

    public String eventNameText() {

        return eventName.getText();
    }


}
