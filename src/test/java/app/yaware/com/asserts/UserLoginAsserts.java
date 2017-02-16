package app.yaware.com.asserts;

import app.yaware.com.pageobjects.UserLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static app.yaware.com.utils.Wait.getPresentElement;

public class UserLoginAsserts {

    //  checks the presence of login page
    public static void assertUserLoginPage(WebDriver driver, UserLoginPage userLoginPage) {
        Assert.assertTrue(driver.findElement(userLoginPage.getCHECKBOX_REMEMBER_ME()).isDisplayed(),
                "Login page was not loaded");
    }

    //  checks the presence of pop-up alert near password input field
    public static void assertPasswordPopup(WebDriver driver, UserLoginPage userLoginPage) {
        Assert.assertTrue(getPresentElement(driver, userLoginPage.getPOPUP_ALERT_PASSWORD()).isDisplayed(),
                "Password popup is absent");
    }

    //  checks successful logout and redirecting onto login page
    public static void assertSuccessfulLogout(WebDriver driver, UserLoginPage userLoginPage) {
        Assert.assertTrue(driver.findElement(userLoginPage.getCHECKBOX_REMEMBER_ME()).isDisplayed(),
                "User still in system");
    }
}