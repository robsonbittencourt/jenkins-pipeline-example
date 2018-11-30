package com.rbittencourt.ui.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextField {

    private WebDriver driver;
    private By selector;

    public TextField(WebDriver driver, By selector) {
        this.driver = driver;
        this.selector = selector;
    }

    public String getText() {
        return ElementFactory.getElement(this.driver, this.selector).getText();
    }

    public void setText(String text) {
        WebElement element = ElementFactory.getElement(this.driver, this.selector);
        element.clear();
        element.sendKeys(text);
    }

}
