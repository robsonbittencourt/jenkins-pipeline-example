package com.rbittencourt.ui.element;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ElementFactory {

    public static WebElement getElement(WebDriver driver, By selector) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(selector));

        return driver.findElement(selector);
    }

}
