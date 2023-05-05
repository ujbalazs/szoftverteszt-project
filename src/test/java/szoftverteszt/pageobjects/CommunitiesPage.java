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

    public CommunitiesPage(WebDriverFactory factory) {
        super(factory);
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public int getCardcountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }
}
