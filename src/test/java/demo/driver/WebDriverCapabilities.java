package demo.driver;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

@RequiredArgsConstructor
public class WebDriverCapabilities {

  public ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
    options.addArguments("--guest");
    if (WebDriverConfig.getHeadless()) {
      options.addArguments("--headless");
    }

    return options;
  }
}
