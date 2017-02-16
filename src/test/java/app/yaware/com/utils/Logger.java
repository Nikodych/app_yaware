package app.yaware.com.utils;

import org.testng.Reporter;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

//  for messages into report
public class Logger {

    private Logger() {

    }

    private static final Date CURRENT_LOG_DATE = new Date();
    private static final Format LOG_FORMATTER = new SimpleDateFormat("HH:mm:ss - ");

    //  information message
    public static void logInfo(final String value) {
        Reporter.log("<p>" + LOG_FORMATTER.format(CURRENT_LOG_DATE)
                + "<b> <font size='1' color='blue'>" + "INFO" + "</font></b>" + " - " + value + "</p>");
    }

    //  message if successful result
    public static void logPass(final String value) {
        Reporter.log("<p>" + LOG_FORMATTER.format(CURRENT_LOG_DATE)
                + "<b> <font size='1' color='green'>" + "PASS" + "</font></b>" + " - " + value + "</p>");
    }

    //  message if failure result
    public static void logFail(final String value) {
        Reporter.log("<p>" + LOG_FORMATTER.format(CURRENT_LOG_DATE)
                + "<b> <font size='1' color='red'>" + "FAIL" + "</font></b>" + " - " + value + "</p>");
    }
}