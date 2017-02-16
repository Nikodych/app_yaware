package app.yaware.com.utils;

import app.yaware.com.enums.Browsers;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    @Getter
    private WebDriver driver;

    final void setDriver(final String browser) {

        final String propertyBrowser = PropertiesReader.getProperty("browser");

        final String webDriverChrome = PropertiesReader.getProperty("webDriver.chrome");

        final String pathWebDriverChrome = PropertiesReader.getProperty("path.webDriver.chrome");

        final Browsers propertyBrowserTypeEnum = Browsers.valueOf(propertyBrowser.toUpperCase());

        final Browsers cmdBrowserTypeEnum = Browsers.valueOf(browser.toUpperCase());

        if ("default".equals(browser)) {
            switch (propertyBrowserTypeEnum) {

                case CHROME:
                    System.setProperty(webDriverChrome, pathWebDriverChrome);
                    driver = new ChromeDriver();
                    break;

                case FIREFOX:
                default:
                    driver = new FirefoxDriver();
                    break;
            }
        } else {
            switch (cmdBrowserTypeEnum) {
                case CHROME:
                    System.setProperty(webDriverChrome, pathWebDriverChrome);
                    driver = new ChromeDriver();
                    break;

                case FIREFOX:
                default:
                    driver = new FirefoxDriver();
                    break;
            }
        }
    }
}