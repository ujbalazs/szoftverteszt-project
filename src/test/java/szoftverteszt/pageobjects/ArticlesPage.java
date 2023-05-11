package szoftverteszt.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import szoftverteszt.factory.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

@Component
public class ArticlesPage extends CommonPageObject{
    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;

    @FindBy(css="html body div#app.evnt-body-wrapper div.evnt-main-container section#agenda_filters.evnt-filters-panel div.evnt-filters-wrapper.desktop div.evnt-filters-heading div#collapseMoreFilters.evnt-more-filters.collapse.show div.evnt-filters-heading-table div.evnt-filters-heading-row div.evnt-filters-heading-cell.cell-1 div.evnt-dropdown-filter.dropdown.show div.evnt-filter-menu.evnt-dropdown-menu.dropdown-menu.with-arrow.show div.evnt-filter-menu-search-wrapper input.evnt-text-fields.form-control.evnt-search")
    private WebElement authorSearchField;

    @FindBy(css=".evnt-filter-menu-items-wrapper")
    private WebElement timeaKovacsCheckBox;

    @FindBy(css = ".evnt-articles-row .evnt-articles-column .evnt-article-text-wrapper")
    private WebElement card;

    @FindBy(css = ".evnt-articles-row .evnt-articles-column")
    private List<WebElement> cards;
    @FindBy(css = ".evnt-promo-articles-panel")
    private WebElement titleBar;
    @FindBy(xpath = "//div[@class='evnt-toogle-filters-text show-more']")
    private WebElement moreFilterButton;
    @FindBy(xpath = "//span[normalize-space()='Language']")
    private WebElement languageDropdown;
    @FindBy(id= "filter_author")
    private WebElement authorDropdown;
    @FindBy(css = "div.evnt-filters-content-cell.evnt-results-cell")
    private WebElement resultNumberCell;
    @FindBy(xpath = "//label[@for='filter_language_0']")
    private WebElement hungarianFilter;
    @FindBy(xpath = "//label[@for='filter_language_2']")
    private WebElement russianFilter;
    @FindBy(id = "dates_toDate")
    private WebElement dateTill;
    @FindBy(xpath = "//a[text()='11']")
    private WebElement date11;


    public ArticlesPage(WebDriverFactory factory) { super(factory); }
    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
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
    public void moreFilterClick(){
        moreFilterButton.click();
    }
    public void dateTillClick(){
        dateTill.click();
    }
    public void date11Click(){
        date11.click();
    }
    public int getCardCountFromResultNumber() {
        return parseInt(resultNumberCell.getText().split(" ", 2)[0]);
    }
        //return cards.size();

    public void languageClick(){
        languageDropdown.click();
    }
    public void authorClick(){
        authorDropdown.click();
    }
    public void hunClick(){
        hungarianFilter.click();
    }
    public void ruClick(){
        russianFilter.click();
    }
    public void searchForAuthor(String searchName) throws InterruptedException {
        authorSearchField.sendKeys(searchName);
        TimeUnit.SECONDS.sleep(1);
    }
    public void clickCheckBox(){
        timeaKovacsCheckBox.click();
    }
    public List<WebElement> getCards() {
        return cards;
    }


}
