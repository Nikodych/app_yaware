package app.yaware.com.tests;

import app.yaware.com.asserts.UserCreateAsserts;
import app.yaware.com.asserts.UserLoginAsserts;
import app.yaware.com.asserts.UserSettingsAsserts;
import app.yaware.com.asserts.UserSystemAsserts;
import app.yaware.com.utils.DataProviders;
import app.yaware.com.utils.TestRunner;
import org.testng.annotations.Test;

public class CreateValidUserTest extends TestRunner {

    /*  Main testing part of user registration with valid data,
    *   after filling data and submitting, opens user setting and
    *   clicking on delete link with cancelling this operation,
    *   going logout.
    */
    @Test(priority = 1, dataProvider = "validRegData", dataProviderClass = DataProviders.class)
    final public void testValidRegistration(final String firstname, final String lastname,
                                            final String email, final String password,
                                            final String phone, final String coupone) {

        UserLoginAsserts.assertUserLoginPage(driver, userLoginPage);

        userCreatePage = userLoginPage.clickTabCreateUser();
        UserCreateAsserts.assertUserCreatePage(driver, userCreatePage);

        userSystemPage = userCreatePage.doRegistration(firstname, lastname, email, password, phone);
        UserSystemAsserts.assertUserSystemPage(driver, userSystemPage);
        UserSystemAsserts.assertPresenceFullname(driver, userSystemPage, firstname, lastname);

        userSettingsPage = userSystemPage.openSettings();
        UserSettingsAsserts.assertUserSettingsPage(driver, userSettingsPage);

        UserSettingsAsserts.assertUserData(driver, userSettingsPage, firstname, lastname, email, phone);

        userLoginPage = userSettingsPage.clickDeleteLink().clickCancel().doLogOut();
        UserLoginAsserts.assertSuccessfulLogout(driver, userLoginPage);
    }

    /*  Testing of possibility doing registration
    *   with same data of previous operation of
    *   registration
    */
    @Test(priority = 2, dataProvider = "validRegData", dataProviderClass = DataProviders.class)
    final public void testExistingUser(final String firstname, final String lastname,
                                       final String email, final String password,
                                       final String phone, final String coupone) {

        userCreatePage = userLoginPage.clickTabCreateUser();
        UserCreateAsserts.assertUserCreatePage(driver, userCreatePage);

        userCreatePage.doRegistration(firstname, lastname, email, password, phone);
        UserCreateAsserts.assertEmailPopup(driver, userCreatePage);
    }

    /*  Testing possibility of login after registration
    *   using the same data with deleting user after that
    */
    @Test(priority = 3, dataProvider = "validRegData", dataProviderClass = DataProviders.class)
    final public void testUserDelete(final String firstname, final String lastname,
                                     final String email, final String password,
                                     final String phone, final String coupone) {

        UserLoginAsserts.assertUserLoginPage(driver, userLoginPage);
        userSystemPage = userLoginPage.logIn(email, password);
        UserSystemAsserts.assertPresenceFullname(driver, userSystemPage, firstname, lastname);
        userSettingsPage = userSystemPage.openSettings();
        UserSettingsAsserts.assertUserSettingsPage(driver, userSettingsPage);
        userLoginPage = userSettingsPage.doDeleteUser();
        userLoginPage.logIn(email, password);
        UserLoginAsserts.assertPasswordPopup(driver, userLoginPage);
    }
}