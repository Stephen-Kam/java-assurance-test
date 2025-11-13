package demo.driver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import java.time.Duration;
import uk.org.webcompere.lightweightconfig.ConfigLoader;

public class Hooks {

  private static final WebDriverConfigProperties webDriverProps =
      ConfigLoader.loadYmlConfigFromResource(
          "config/webdriver.yml", WebDriverConfigProperties.class);

  @BeforeAll
  public static void beforeAll() {
    WebDriverConfig.setTargetUrl(webDriverProps.getUrl());
    WebDriverConfig.setSeleniumHubUrl(webDriverProps.getSeleniumHubUrl());
    WebDriverConfig.setBrowser(webDriverProps.getBrowser());
    WebDriverConfig.setRemote(webDriverProps.getRemote());
    WebDriverConfig.setHeadless(webDriverProps.getHeadless());
    WebDriverConfig.setWaitTime(webDriverProps.getWaitTime());

    if (WebDriverManager.getDriver() == null) {
      WebDriverManager.openBrowser();
    }

    WebDriverManager.getDriver()
        .manage()
        .timeouts()
        .implicitlyWait(Duration.ofSeconds(webDriverProps.getWaitTime()));
    WebDriverManager.getDriver()
        .manage()
        .timeouts()
        .pageLoadTimeout(Duration.ofSeconds(webDriverProps.getWaitTime()));
  }

  @Before
  public void before() {
    WebDriverManager.getDriver().manage().deleteAllCookies();
  }

  @AfterAll
  public static void afterAll() {
    WebDriverManager.closeBrowser();
  }
}
