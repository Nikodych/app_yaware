package app.yaware.com.asserts;

import app.yaware.com.pageobjects.UserSettingsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserSettingsAsserts {

    //  checks the presence of user settings page
    public static void assertUserSettingsPage(WebDriver driver, UserSettingsPage userSettingsPage) {
        Assert.assertTrue(driver.findElement(userSettingsPage.getLINK_DELETE_USER()).isDisplayed(),
                "User settings page was not loaded");
    }

    //  checks value of firstname input field
    public static void assertFirstnameField(WebDriver driver, UserSettingsPage userSettingsPage, String firstname) {
        Assert.assertTrue(driver.findElement(userSettingsPage.getINPUT_FIELD_FIRSTNAME())
                        .getAttribute("value").contains(firstname),
                "First name is different");
    }

    //  checks value of lastname input field
    public static void assertLastnameField(WebDriver driver, UserSettingsPage userSettingsPage, String lastname) {
        Assert.assertTrue(driver.findElement(userSettingsPage.getINPUT_FIELD_LASTNAME())
                        .getAttribute("value").contains(lastname),
                "Last name is different");
    }

    //  checks value of email input field
    public static void assertEmailField(WebDriver driver, UserSettingsPage userSettingsPage, String email) {
        Assert.assertTrue(driver.findElement(userSettingsPage.getINPUT_FIELD_EMAIL())
                        .getAttribute("value").contains(email),
                "Email is different");
    }

    //  checks value of phone input field
    public static void assertPhoneField(WebDriver driver, UserSettingsPage userSettingsPage, String phone) {
        Assert.assertTrue(driver.findElement(userSettingsPage.getINPUT_FIELD_PHONE())
                        .getAttribute("value").replaceAll("[^0-9]", "").contains(phone),
                "Phone is different");
    }

    //  checks values of all input fields on user settings page
    public static void assertUserData(WebDriver driver, UserSettingsPage userSettingsPage,
                                      String firstname, String lastname, String email, String phone) {
        assertFirstnameField(driver, userSettingsPage, firstname);
        assertLastnameField(driver, userSettingsPage, lastname);
        assertEmailField(driver, userSettingsPage, email);
        assertPhoneField(driver, userSettingsPage, phone);
    }
}