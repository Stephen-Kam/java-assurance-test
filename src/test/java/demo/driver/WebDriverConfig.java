package demo.driver;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class WebDriverConfig {

  @Getter @Setter private static String targetUrl;
  @Getter @Setter private static String seleniumHubUrl;
  @Setter private static String browser;
  @Getter @Setter private static Boolean remote;
  @Getter @Setter private static Boolean headless;
  @Getter @Setter private static int waitTime;

  public static String getBrowser() {
    if (browser == null) {
      browser = "chrome";
    }

    return browser;
  }
}
