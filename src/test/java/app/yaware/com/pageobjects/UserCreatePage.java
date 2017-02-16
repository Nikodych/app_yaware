package app.yaware.com.pageobjects;

import app.yaware.com.utils.Logger;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class UserCreatePage extends PageObject {

    //  locators only for used elements of web site
    private final By INPUT_FIELD_FIRSTNAME = By.id("firstname");
    private final By INPUT_FIELD_LASTNAME = By.id("lastname");
    private final By INPUT_FIELD_EMAIL = By.id("registerEmail");
    private final By INPUT_FIELD_PASSWORD = By.id("pwd1");
    private final By INPUT_FIELD_PHONE = By.id("phone");
    private final By INPUT_FIELD_COUPON = By.id("coupone_code");
    private final By BUTTON_SUBMIT_REGISTRATION = By.id("register-account-submit");
    private final By LINK_COUPON = By.xpath("//div[@id='form-field-coupone_code_link']/a");
    private final By POPUP_ALERT_FIRSTNAME = By.xpath("//div[@id='form-field-firstname']//div[@class='tooltip-inner']");
    private final By POPUP_ALERT_LASTNAME = By.xpath("//div[@id='form-field-lastname']//div[@class='tooltip-inner']");
    private final By POPUP_ALERT_EMAIL = By.xpath("//div[@id='form-field-registerEmail']//div[@class='tooltip-inner']");
    private final By POPUP_ALERT_PASSWORD = By.xpath("//div[@id='form-field-pwd1']//div[@class='tooltip-inner']");
    private final By POPUP_ALERT_PHONE = By.xpath("//div[@id='form-field-phone']//div[@class='tooltip-inner']");
    private final By POPUP_ALERT_COUPON = By.xpath("//div[@id='form-field-coupone_code']//div[@class='tooltip-inner']");

    public UserCreatePage(final WebDriver driver) {
        super(driver);
    }

    //  filling of all fields and submitting
    public final UserSystemPage doRegistration(final String firstname, final String lastname,
                                               final String email, final String password,
                                               final String phone) {
        setFirstname(firstname)
                .setLastname(lastname)
                .setEmail(email)
                .setPassword(password)
                .setPhone(phone)
                .clickSubmit();
        return new UserSystemPage(driver);
    }

    //  filling firstname field
    public final UserCreatePage setFirstname(final String firstname) {
        getElement(INPUT_FIELD_FIRSTNAME).sendKeys(firstname);
        Logger.logInfo("<font color='black'>Firstname field "
                + "<b>" + firstname + "</b></font>");
        return this;
    }

    //  filling lastname field
    public final UserCreatePage setLastname(final String lastname) {
        getElement(INPUT_FIELD_LASTNAME).sendKeys(lastname);
        Logger.logInfo("<font color='black'>Lastname field "
                + "<b>" + lastname + "</b></font>");
        return this;
    }

    //  filling email field
    public final UserCreatePage setEmail(final String email) {
        getElement(INPUT_FIELD_EMAIL).sendKeys(email);
        Logger.logInfo("<font color='black'>Email field "
                + "<b>" + email + "</b></font>");
        return this;
    }

    //  filling password field
    public final UserCreatePage setPassword(final String password) {
        getElement(INPUT_FIELD_PASSWORD).sendKeys(password);
        Logger.logInfo("<font color='black'>Password field "
                + "<b>" + password + "</b></font>");
        return this;
    }

    //  filling phone field
    public final UserCreatePage setPhone(final String phone) {
        getElement(INPUT_FIELD_PHONE).clear();
        getElement(INPUT_FIELD_PHONE).sendKeys(phone);
        Logger.logInfo("<font color='black'>Phone field "
                + "<b>" + phone + "</b></font>");
        return this;
    }

    //  filling coupon field after click on coupon link
    public final UserCreatePage setCoupon(final String coupon) {
        getElement(LINK_COUPON).click();
        Logger.logInfo("<font color='black'>Clicked "
                + "<b>" + "Coupon link" + "</b></font>");
        getElement(INPUT_FIELD_COUPON).sendKeys(coupon);
        Logger.logInfo("<font color='black'>Coupon field "
                + "<b>" + coupon + "</b></font>");
        return this;
    }

    //  submitting registration button
    public final UserSystemPage clickSubmit() {
        getElement(BUTTON_SUBMIT_REGISTRATION).click();
        Logger.logInfo("<font color='black'>Clicked "
                + "<b>" + "Submit button" + "</b></font>");
        return new UserSystemPage(driver);
    }
}