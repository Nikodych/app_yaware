package app.yaware.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageObject {

    protected WebDriver driver;

    public PageObject(final WebDriver driver) {
        this.driver = driver;
    }

    public final WebElement getElement(final By elementLocation) {
        return driver.findElement(elementLocation);
    }
}