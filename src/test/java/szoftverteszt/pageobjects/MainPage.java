package szoftverteszt.pageobjects;

import szoftverteszt.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends CommonPageObject {

    @FindBy(className = "communities-icon")
    private WebElement communitiesButton;

    @FindBy(className = "events-icon")
    private WebElement eventsButton;

    @FindBy(className = "articles-icon")
    private WebElement articlesButton;

    @FindBy(className = "speakers-icon")
    private WebElement speakersButton;

    public MainPage(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }

    public void clickCommunities() {
        communitiesButton.click();
    }

    public void clickEvents() {
        eventsButton.click();
    }

    public void clickArticles() {
        articlesButton.click();
    }

    public void clickSpeakers() {
        speakersButton.click();
    }
}
