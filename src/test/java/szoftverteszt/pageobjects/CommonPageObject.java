package szoftverteszt.pageobjects;

import szoftverteszt.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonPageObject {
    protected WebDriver driver;

    public CommonPageObject(WebDriverFactory webDriverFactory) {
        this.driver = webDriverFactory.getWebDriver();
        PageFactory.initElements(driver, this);
    }
}
