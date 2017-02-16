package app.yaware.com.asserts;

import app.yaware.com.pageobjects.UserCreatePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserCreateAsserts {

    //  checks the presence of registration page
    public static void assertUserCreatePage(WebDriver driver, UserCreatePage userCreatePage) {
        Assert.assertTrue(driver.findElement(userCreatePage.getBUTTON_SUBMIT_REGISTRATION()).isDisplayed(),
                "Registration page was not loaded");
    }

    //  checks the presence of pop-up alert near firstname input field
    public static void assertFirstnamePopup(WebDriver driver, UserCreatePage userCreatePage) {
        Assert.assertTrue(driver.findElement(userCreatePage.getPOPUP_ALERT_FIRSTNAME()).isDisplayed(),
                "Firstname popup is absent");
    }

    //  checks the presence of pop-up alert near lastname input field
    public static void assertLastnamePopup(WebDriver driver, UserCreatePage userCreatePage) {
        Assert.assertTrue(driver.findElement(userCreatePage.getPOPUP_ALERT_LASTNAME()).isDisplayed(),
                "Lastname popup is absent");
    }

    //  checks the presence of pop-up alert near email input field
    public static void assertEmailPopup(WebDriver driver, UserCreatePage userCreatePage) {
        Assert.assertTrue(driver.findElement(userCreatePage.getPOPUP_ALERT_EMAIL()).isDisplayed(),
                "Email popup is absent");
    }

    //  checks the presence of pop-up alert near password input field
    public static void assertPasswordPopup(WebDriver driver, UserCreatePage userCreatePage) {
        Assert.assertTrue(driver.findElement(userCreatePage.getPOPUP_ALERT_PASSWORD()).isDisplayed(),
                "Password popup is absent");
    }

    //  checks the presence of pop-up alert near phone input field
    public static void assertPhonePopup(WebDriver driver, UserCreatePage userCreatePage) {
        Assert.assertTrue(driver.findElement(userCreatePage.getPOPUP_ALERT_PHONE()).isDisplayed(),
                "Phone popup is absent");
    }

    //  checks the presence of pop-up alert near coupone input field
    public static void assertCouponePopup(WebDriver driver, UserCreatePage userCreatePage) {
        Assert.assertTrue(driver.findElement(userCreatePage.getPOPUP_ALERT_COUPON()).isDisplayed(),
                "Coupone popup is absent");
    }

    //  checks the presence of all pop-up alerts on registration page
    public static void assertAlertPopups(WebDriver driver, UserCreatePage userCreatePage) {
        assertFirstnamePopup(driver, userCreatePage);
        assertLastnamePopup(driver, userCreatePage);
        assertEmailPopup(driver, userCreatePage);
        assertPasswordPopup(driver, userCreatePage);
        assertPhonePopup(driver, userCreatePage);
    }
}