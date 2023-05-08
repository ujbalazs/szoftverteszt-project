package szoftverteszt.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.util.Objects;

public class WebDriverFactory {
    public static final int WAIT_TIME_SECONDS = 10;
    private WebDriver webDriver;

    @Value("${headless:false}")
    private Boolean headless;

    @Value("${browser:chrome}")
    private String browserName;

    private WebDriver setupWebDriver() {
        var webDriver = browserSpecificSetup();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_SECONDS));
        return webDriver;
    }

    private WebDriver browserSpecificSetup() {
        switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(
                    new ChromeOptions()
                        .addArguments("--remote-allow-origins=*")
                        .addArguments("--no-sandbox")
                        .addArguments("--disable-dev-shm-usage")
                        .setHeadless(headless)
                );
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new FirefoxOptions().setHeadless(headless));
            }
            case "safari" -> {
                if (headless) {
                    throw new RuntimeException("Safari browser does not support headless execution.");
                }
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            }
            default -> throw new RuntimeException("Provided browser is not supported!");
        }
    }

    public WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            webDriver = setupWebDriver();
        }
        return webDriver;
    }

    public JavascriptExecutor getJsExecutor() {
        if (Objects.isNull(webDriver)) {
            webDriver = setupWebDriver();
        }
        return (JavascriptExecutor) webDriver;
    }

    public void tearDown() {
        if (Objects.nonNull(webDriver)) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
