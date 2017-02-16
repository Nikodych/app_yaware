package app.yaware.com.pageobjects;

import app.yaware.com.utils.Logger;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static app.yaware.com.utils.Wait.getClickableElement;

@Getter
public class UserSystemPage extends PageObject {

    //  locators only for used elements of web site
    private final By TEXT_FIELD_USERNAME = By.xpath("//p[@class='username']");
    private final By BUTTON_USER_SETTINGS = By.xpath("//a[@href='/my-account']");

    public UserSystemPage(final WebDriver driver) {
        super(driver);
    }

    //  opening user settings
    public final UserSettingsPage openSettings() {
        getClickableElement(driver, BUTTON_USER_SETTINGS).click();
        Logger.logInfo("<font color='black'>Clicked "
                + "<b>" + "User Settings Button" + "</b></font>");
        return new UserSettingsPage(driver);
    }
}