package com.rbittencourt.ui.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.rbittencourt.ui.driver.DriverFactory;

public class TextField {

    private By selector;

    public TextField(By selector) {
        this.selector = selector;
    }

    public String getText() {
        WebElement element = DriverFactory.getInstance().findElement(selector);
        return element.getText();
    }

    public void setText(String text) {
        WebElement element = DriverFactory.getInstance().findElement(selector);
        element.clear();
        element.sendKeys(text);
    }

}
