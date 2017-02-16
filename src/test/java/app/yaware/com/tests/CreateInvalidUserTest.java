package app.yaware.com.tests;

import app.yaware.com.asserts.UserCreateAsserts;
import app.yaware.com.utils.DataProviders;
import app.yaware.com.utils.TestRunner;
import org.testng.annotations.Test;

public class CreateInvalidUserTest extends TestRunner {

    //  Testing possibility of registration with invalid data
    @Test(dataProvider = "invalidRegData", dataProviderClass = DataProviders.class)
    final public void testInvalidRegistration(final String firstname, final String lastname,
                                              final String email, final String password,
                                              final String phone) {

        userCreatePage = userLoginPage.clickTabCreateUser();
        UserCreateAsserts.assertUserCreatePage(driver, userCreatePage);

        userCreatePage.doRegistration(firstname, lastname, email, password, phone);
        UserCreateAsserts.assertAlertPopups(driver, userCreatePage);

    }

    /*  Testing possibility of registration
    *   with valid data and invalid coupone
    */
    @Test(dataProvider = "validRegData", dataProviderClass = DataProviders.class)
    final public void testCouponRegistration(final String firstname, final String lastname,
                                             final String email, final String password,
                                             final String phone, final String coupone) {

        userCreatePage = userLoginPage.clickTabCreateUser();
        UserCreateAsserts.assertUserCreatePage(driver, userCreatePage);

        userCreatePage
                .setFirstname(firstname)
                .setLastname(lastname)
                .setEmail(email)
                .setPassword(password)
                .setPhone(phone)
                .setCoupon(coupone)
                .clickSubmit();

        UserCreateAsserts.assertCouponePopup(driver, userCreatePage);
    }
}