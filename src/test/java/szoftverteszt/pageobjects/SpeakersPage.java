package szoftverteszt.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import szoftverteszt.factory.WebDriverFactory;

import java.util.List;

@Component
public class SpeakersPage extends CommonPageObject {

    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;

    @FindBy(css = ".evnt-users-row .evnt-users-column .evnt-user-name")
    private WebElement card;

    @FindBy(css = ".evnt-users-row .evnt-users-column")
    private List<WebElement> cards;

    @FindBy(css = ".evnt-speakers-hero")
    private WebElement titleBar;

    public SpeakersPage(WebDriverFactory factory) {super(factory);}

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




}
