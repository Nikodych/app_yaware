package app.yaware.com.utils;

import org.testng.annotations.DataProvider;

public final class DataProviders {

    private DataProviders() {

    }

    //  Valid data with invalid coupon as far as valid information was not provided
    @DataProvider
    public static Object[][] validRegData() {
        return new Object[][]{

                {"N", "L", "m@m.com", "qwerty", "8164891652",
                        "SELECT * FROM Users WHERE Username='1' OR '1' = '1' AND Password='1' OR '1' = '1'"},

                {"Username", "Lastname",
                        "!@TestingEmailFieldWithSomeVeryLongHostnameWith15NumbersAnd-Minus.com",
                        "SomeVeryLongPasswordWithNumbersAndSigns2323!!5" +
                                "grdgdhmas-gdg_dsfewv321someverylongpasswordwithnumbersandsigns2323!!5" +
                                "grdgdhmas-gdg_dsfewv321someverylongpasswordwithnumbersandsigns2323!!5" +
                                "grdgdhmas-gdg_dsfewv321someverylongpasswordwithnumbersandsigns2323!!5" +
                                "grdgdhmas-gdg_dsfewv321someverylongpasswordwith", "123456789012", "Lucky"},

                {"SomeVeryLongFirstNameSomeVeryLongFirstNameSomeVeryLongFirstName" +
                        "SomeVeryLongFirstNameSomeVeryLongFirstNameSomeVeryLongFirstName" +
                        "SomeVeryLongFirstNameSomeVeryLongFirstNameSomeVeryLongFirstName" +
                        "SomeVeryLongFirstNameSomeVeryLongFirstName",
                        "SomeVeryLongLastNameSomeVeryLongLastNameSomeVeryLongLastName" +
                                "SomeVeryLongLastNameSomeVeryLongLastNameSomeVeryLongLastName" +
                                "SomeVeryLongLastNameSomeVeryLongLastNameSomeVeryLongLastName" +
                                "SomeVeryLongLastNameSomeVeryLongLastNameSomeVeryLongLastName",
                        "user12_n@mail-911.net", " somePassword15_with spaces ", "9801648231",
                        "<img src=”<img src='<img src=.>’>”onerror=alert(9)>"},

                {"Some Name", "Some Last name", "VeryLong_Email-WithNumbersAndSigns555VeryLong" +
                        "_Email-With5Numbers@TestingEmailFieldWithSomeVeryLongHostnameWith15NumbersAnd-Minus.edu.com",
                        "123456", "3805551298", "coupon"},

                {"Ім'я", "Прізвыщє", "VeryLong_Email-WithNumbersAndSigns555VeryLong_Email-With5Numbers@1.com.ua",
                        "Складный_паролі", "44898726564", "土 戈 走 龰 戉"},

                {"Ім'я Usera", "ФамілїЭ Usera", "mail@пошта.com",
                        "SELECT * FROM Users WHERE Username='1' OR '1' = '1' AND Password='1' OR '1' = '1' ",
                        "7456521348", "000012345"},

                {"土 戈 走 龰 戉", "チ ヂ ッ ツ ヅ テ デ ト ド ナ ニ ヌ", "mail@mail.jp",
                        "土 戈 走 龰 戉", "541234532979", "1"}
        };
    }

    //  invalid data
    @DataProvider
    public static Object[][] invalidRegData() {
        return new Object[][]{
                {"", "", "", "", ""},

                {"FirstName1", "LastName1", "mail@mail.mail", "qwert", "PhoneNumber"},

                {"First▬Name☼", "Last¶Name▐", "mail$mail.com", "1", "!@#$%№"},

                {"946", "157", "mail@com", "pass", "    "},

                {"!@#$%№", "☺☻♥♦♣♠•◘○♫♀☼♪►↕◄‼", "@host.name", "12345", "448756329"},

                {"12345&*()_", "q+=*-/\\", "mail@mailcom", "54321", "4512348754813"},

                {"\"Name\"", "\"Surname\"", "ma1 !l@h0st.name", "1qaz", "888888888"},

                {"SELECT * FROM Users WHERE Username='1' OR '1' = '1' AND Password='1' OR '1' = '1'",
                        "<img src=”<img src='<img src=.>’>”onerror=alert(9)>", "mai╝@mail.gov.ua",
                        "PASS", "55555"},

                {"<img src=”<img src='<img src=.>’>”onerror=alert(9)>",
                        "SELECT * FROM Users WHERE Username='1' OR '1' = '1' AND Password='1' OR '1' = '1'",
                        "пошта@mail.ua", "!@#$%", "1"},

                {"USERN@ME", "&astname", "mail@mail.уа", "66666", "333"},

                {"T0d", "T()D", "mail@@mail.com", "=1+5", "666666"},

                {"http://images11.postadsuk.com/2016/10/06/postadsuk.com-4-dog-walking-and-pet-sitting" +
                        "-services-happy-tails-any-pets-considere-all-areas-in-salford-petsitter.JPG",
                        "https://www.petdrugsonline.co.uk/images/page-headers/cats-master-header",
                        "mail@mail.гов.us", "=7-1", "22"},

                {"https://www.petdrugsonline.co.uk/images/page-headers/cats-master-header",
                        "http://images11.postadsuk.com/2016/10/06/postadsuk.com-4-dog-walking-and-pet-sitting" +
                                "-services-happy-tails-any-pets-considere-all-areas-in-salford-petsitter.JPG",
                        "пошта@мейл.ком", "99999", "0"}
        };
    }
}