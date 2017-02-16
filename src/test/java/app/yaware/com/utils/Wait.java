package app.yaware.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {

    private Wait() {

    }

    /**
     * Method is used to wait for the presence of element
     *
     * @param driver
     * @param locator
     * @return
     */
    public static final WebElement getPresentElement(final WebDriver driver, By locator) {

        int timeout = 30;
        return new WebDriverWait(driver, timeout)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Method is used to wait for disappearing locator
     *
     * @param driver
     * @param locator
     * @return
     */
    public static final Boolean waitDisappearing(final WebDriver driver, By locator) {

        int timeout = 30;
        return new WebDriverWait(driver, timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Method is used to wait for element to be clickable
     *
     * @param driver
     * @param locator
     * @return
     */
    public static final WebElement getClickableElement(final WebDriver driver, By locator) {

        int timeout = 30;
        return new WebDriverWait(driver, timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}