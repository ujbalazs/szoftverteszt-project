package szoftverteszt.pageobjects;

import szoftverteszt.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
