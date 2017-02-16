package app.yaware.com.asserts;

import app.yaware.com.pageobjects.UserSystemPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserSystemAsserts {

    //  checks the presence of user system page
    public static void assertUserSystemPage(WebDriver driver, UserSystemPage userSystemPage) {
        Assert.assertTrue(driver.findElement(userSystemPage.getTEXT_FIELD_USERNAME()).isDisplayed(),
                "User system page was not loaded");
    }

    //  checks the presence firstname and lastname of user in text field
    public static void assertPresenceFullname(WebDriver driver, UserSystemPage userSystemPage,
                                              String firstname, String lastname) {
        Assert.assertTrue(driver.findElement(userSystemPage.getTEXT_FIELD_USERNAME())
                        .getAttribute("title").contains(firstname),
                "The first name absent");
        Assert.assertTrue(driver.findElement(userSystemPage.getTEXT_FIELD_USERNAME())
                        .getAttribute("title").contains(lastname),
                "The last name absent");
    }
}