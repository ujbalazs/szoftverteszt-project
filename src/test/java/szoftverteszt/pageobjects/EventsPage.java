package szoftverteszt.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import szoftverteszt.factory.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

@Component
public class EventsPage extends CommonPageObject {

    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement headerSearchBar;

    @FindBy(css = ".evnt-events-row .evnt-events-column .evnt-name-wrapper")
    private WebElement card;

    @FindBy(css = ".evnt-events-row .evnt-events-column")
    private List<WebElement> cards;

    @FindBy(xpath = "//h1[contains(text(),'Events')]")
    private WebElement titleBar;

    @FindBy(id = "filter_location")
    private WebElement locationDropdown;

    @FindBy(xpath = "//div[@class='evnt-filter-menu evnt-dropdown-menu dropdown-menu with-arrow show']//input[@placeholder='Start typing']")
    private WebElement locationSearch;

    @FindBy(className = "form-check-label")
    private WebElement locationCheckbox;

    @FindBy(xpath = "//div[@class='evnt-toogle-filters-text show-more']")
    private WebElement moreFilterButton;

    @FindBy(xpath = "//label[@for='online_Online']")
    private WebElement onlineSwitch;

    @FindBy(xpath = "(//span[contains(@class,'evnt-tab-counter')])[1]")
    private WebElement upcomingEventsNumber;

    @FindBy(xpath = "(//span[contains(@class,'evnt-tab-counter')])[2]")
    private WebElement pastEventsNumber;

    @FindBy(xpath = "//span[normalize-space()='Language']")
    private WebElement languageDropdown;

    @FindBy(xpath = "//label[@for='filter_language_5']")
    private WebElement englishFilter;

    @FindBy(xpath = "//label[@for='filter_language_7']")
    private WebElement hungarianFilter;

    @FindBy(id = "dates_toDate")
    private WebElement dateTill;

    @FindBy(xpath = "//a[text()='11']")
    private WebElement date11;

    @FindBy(xpath = "//label[@for='filter_location_11']")
    private WebElement hungaryLocationFilter;

    @FindBy(xpath = "//span[contains(text(),'Past')]")
    private WebElement pastEventsTab;

    @FindBy(xpath = "//span[contains(text(),'Upcoming')]")
    private WebElement upcomingEventsTab;

    @FindBy(xpath = "//h2[contains(text(),'Coolest Project 2023 tavasz')]")
    private WebElement searchedCard;





    public EventsPage(WebDriverFactory factory) {
        super(factory);
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }
    public void clickSearchIcon() { headerSearchBar.click(); }

    public List<WebElement> getCards() {
        return cards;
    }

    public boolean isOpened() {
        return titleBar.isDisplayed();
    }

    public boolean isHeaderSearchActive() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return headerSearchBar.getAttribute("class").contains("active");
    }

    public void searchBarClick(){
        searchField.click();
    }

    public void locationDropdownClick(){
        locationDropdown.click();
    }

    public void moreFilterClick(){
        moreFilterButton.click();
    }

    public int getCardCountFromUpcomingNumber() {
        return parseInt(upcomingEventsNumber.getText());
    }

    public int getCardCountFromPastNumber() {
        return parseInt(pastEventsNumber.getText());
    }

    public void languagegClick(){
        languageDropdown.click();
    }
    public void engClick(){
        englishFilter.click();
    }

    public void hunClick(){
        hungarianFilter.click();
    }

    public void hungaryLocationClick(){
        hungaryLocationFilter.click();
    }

    public void dateTillClick(){
        dateTill.click();
    }

    public void date11Click(){
        date11.click();
    }

    public void pastEventsTabClick(){
        pastEventsTab.click();
    }

    public void upcomingEventsTabClick(){
        upcomingEventsTab.click();
    }

    public boolean searchedCard() {
        return searchedCard.isDisplayed();
    }

}
