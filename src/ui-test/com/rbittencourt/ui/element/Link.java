package com.rbittencourt.ui.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Link {

    private WebDriver driver;
    private By selector;

    public Link(WebDriver driver, By selector) {
        this.driver = driver;
        this.selector = selector;
    }

    public void click() {
        ElementFactory.getElement(this.driver, this.selector).click();
    }

    public boolean isVisible() {
        return ElementFactory.getElement(this.driver, this.selector).isDisplayed();
    }

}
