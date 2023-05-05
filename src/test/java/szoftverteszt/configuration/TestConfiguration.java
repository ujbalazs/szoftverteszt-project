package szoftverteszt.configuration;

import szoftverteszt.factory.WebDriverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("szoftverteszt")
public class TestConfiguration {

    @Bean(destroyMethod = "tearDown")
    public WebDriverFactory webDriverFactory() {
        return new WebDriverFactory();
    }
}
