package app.yaware.com.pageobjects;

import app.yaware.com.utils.Logger;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static app.yaware.com.utils.Wait.*;

@Getter
public class UserSettingsPage extends PageObject {

    //  locators only for used elements of web site
    private final By INPUT_FIELD_FIRSTNAME = By.id("firstname");
    private final By INPUT_FIELD_LASTNAME = By.id("lastname");
    private final By INPUT_FIELD_EMAIL = By.id("email");
    private final By INPUT_FIELD_PHONE = By.id("phone");
    private final By BUTTON_LOG_OUT = By.xpath("//a[@href='/logout']");
    private final By MODAL_DIALOG_WINDOW = By.xpath("//div[@id='modal']/div[@class='modal-dialog']");
    private final By BUTTON_DELETE = By.id("yaware-modal-button-0");
    private final By BUTTON_CLOSE = By.id("yaware-modal-button-1");
    private final By LINK_DELETE_USER = By.id("delete-account");

    public UserSettingsPage(final WebDriver driver) {
        super(driver);
    }

    //  full deleting of user
    public final UserLoginPage doDeleteUser() {
        clickDeleteLink().clickConfirm();
        return new UserLoginPage(driver);
    }

    //  logout from system
    public final UserLoginPage doLogOut() {
        getClickableElement(driver, BUTTON_LOG_OUT).click();
        Logger.logInfo("<font color='black'>Clicked "
                + "<b>" + "LogOut Button" + "</b></font>");
        return new UserLoginPage(driver);
    }

    //  clicking at delete user link
    public final UserSettingsPage clickDeleteLink() {
        getPresentElement(driver, LINK_DELETE_USER).click();
        Logger.logInfo("<font color='black'>Clicked "
                + "<b>" + "Delete User Link" + "</b></font>");
        return this;
    }

    //  cancellation of deleting
    public final UserSettingsPage clickCancel() {
        getClickableElement(driver, BUTTON_CLOSE).click();
        Logger.logInfo("<font color='black'>Clicked "
                + "<b>" + "Close Button" + "</b></font>");
        while (!waitDisappearing(driver, MODAL_DIALOG_WINDOW)) {
        }
        return this;
    }

    //  confirmation of deleting
    public final UserLoginPage clickConfirm() {
        getClickableElement(driver, BUTTON_DELETE).click();
        Logger.logInfo("<font color='black'>Clicked "
                + "<b>" + "Delete Button" + "</b></font>");
        while (!waitDisappearing(driver, MODAL_DIALOG_WINDOW)) {
        }
        return new UserLoginPage(driver);
    }
}