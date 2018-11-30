package com.rbittencourt.ui.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Paragraph {

    private WebDriver driver;
    private By selector;

    public Paragraph(WebDriver driver, By selector) {
        this.driver = driver;
        this.selector = selector;
    }

    public void getText() {
        ElementFactory.getElement(this.driver, this.selector).getText();
    }

}
