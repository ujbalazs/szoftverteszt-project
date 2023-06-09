package szoftverteszt.pageobjects;

import szoftverteszt.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.Integer.parseInt;

@Component
public class CommunitiesPage extends CommonPageObject {

    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;

    @FindBy(css = ".evnt-communities-row .evnt-communities-column .evnt-name-wrapper")
    private WebElement card;

    @FindBy(css = ".evnt-communities-row .evnt-communities-column")
    private List<WebElement> cards;

    @FindBy(css = ".evnt-communities-hero")
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

    @FindBy(css = ".evnt-filters-content-cell.evnt-results-cell")
    private WebElement resultNumberCell;

    @FindBy(xpath = "//span[normalize-space()='Language']")
    private WebElement languageDropdown;

    @FindBy(xpath = "//label[@for='filter_language_1']")
    private WebElement englishFilter;

    @FindBy(xpath = "//label[@for='filter_language_2']")
    private WebElement hungarianFilter;





    public CommunitiesPage(WebDriverFactory factory) {
        super(factory);
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public int getCardCountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }

    public List<WebElement> getCards() {
        return cards;
    }

    public boolean isOpened() {
        return titleBar.isDisplayed();
    }

    public boolean isSearchOnPage() {
        return searchField.isDisplayed();
    }

    public void searchBarClick(){
        searchField.click();
    }

    public void locationDropdownClick(){
        locationDropdown.click();
    }

    public boolean searchIsEmpty() {
        return searchField.getAttribute("value").equals("");
    }

    public void searchLocation(String searchLoc) {
        locationSearch.sendKeys(searchLoc);
    }

    public void locationCheckboxClick(){
        locationCheckbox.click();
    }

    public void moreFilerClick(){
        moreFilterButton.click();
    }

    public void onlineClick(){
        onlineSwitch.click();
    }
    public int getCardCountFromResultNumber() {
        return parseInt(resultNumberCell.getText().split(" ", 2)[0]);
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

}
