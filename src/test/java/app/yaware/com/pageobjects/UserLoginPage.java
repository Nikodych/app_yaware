package app.yaware.com.pageobjects;

import app.yaware.com.utils.Logger;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static app.yaware.com.utils.Wait.getPresentElement;

@Getter
public class UserLoginPage extends PageObject {

    //  locators only for used elements of web site
    private final By TAB_CREATE_NEW_USER = By.xpath("//section[@id='main-content']//a[@href='#register']");
    private final By INPUT_FIELD_EMAIL = By.id("email");
    private final By INPUT_FIELD_PASSWORD = By.id("password");
    private final By CHECKBOX_REMEMBER_ME = By.xpath("//div[@id='form-field-rememberMe']/label");
    private final By BUTTON_ENTRY_SYSTEM = By.id("login-submit");
    private final By POPUP_ALERT_EMAIL = By.xpath("//div[@id='form-field-email']//div[@class='tooltip-inner']");
    private final By POPUP_ALERT_PASSWORD = By.xpath("//div[@id='form-field-password']//div[@class='tooltip-inner']");

    public UserLoginPage(final WebDriver driver) {
        super(driver);
    }

    //  filling of all fields and submitting
    public final UserSystemPage logIn(final String userEmail, final String userPassword) {
        setUserEmail(userEmail)
                .setUserPassword(userPassword)
                .enterSystem();
        return new UserSystemPage(driver);
    }

    //  filling email field
    private UserLoginPage setUserEmail(final String userEmail) {
        getPresentElement(driver, INPUT_FIELD_EMAIL).sendKeys(userEmail);
        Logger.logInfo("<font color='black'>Email field "
                + "<b>" + userEmail + "</b></font>");
        return this;
    }

    //  filling password field
    private UserLoginPage setUserPassword(final String userPassword) {
        getPresentElement(driver, INPUT_FIELD_PASSWORD).sendKeys(userPassword);
        Logger.logInfo("<font color='black'>Password field "
                + "<b>" + userPassword + "</b></font>");
        return this;
    }

    //  submit entering system
    private UserSystemPage enterSystem() {
        getPresentElement(driver, BUTTON_ENTRY_SYSTEM).click();
        Logger.logInfo("<font color='black'>Clicked "
                + "<b>" + "Entry button" + "</b></font>");
        return new UserSystemPage(driver);
    }

    //  moving onto registration page
    public final UserCreatePage clickTabCreateUser() {
        getPresentElement(driver, TAB_CREATE_NEW_USER).click();
        Logger.logInfo("<font color='black'>Clicked "
                + "<b>" + "Create User tab" + "</b></font>");
        return new UserCreatePage(driver);
    }
}