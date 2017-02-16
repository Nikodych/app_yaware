package app.yaware.com.utils;

import app.yaware.com.pageobjects.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    @Getter
    protected WebDriver driver;

    protected UserCreatePage userCreatePage;
    protected UserLoginPage userLoginPage;
    protected UserSettingsPage userSettingsPage;
    protected UserSystemPage userSystemPage;

    @Parameters("browser")
    @BeforeMethod
    public final void setUp(@Optional("default") final String browser) {

        final String startPageUrl = PropertiesReader.getProperty("home.url");

        final int timeOut = Integer.parseInt(PropertiesReader.getProperty("timeOut"));

        final WebDriverFactory webDriverFactory = new WebDriverFactory();

        webDriverFactory.setDriver(browser);

        driver = webDriverFactory.getDriver();

        driver.manage()
                .window()
                .maximize();

        driver.manage()
                .timeouts()
                .implicitlyWait(timeOut, TimeUnit.SECONDS);

        driver.get(startPageUrl);

        userLoginPage = new UserLoginPage(driver);
    }

    @AfterMethod
    public final void tearDown() {

        driver.quit();
    }
}