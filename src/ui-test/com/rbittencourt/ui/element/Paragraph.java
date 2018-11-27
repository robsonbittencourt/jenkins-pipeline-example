package com.rbittencourt.ui.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.rbittencourt.ui.driver.DriverFactory;

public class Paragraph {

    private By selector;

    public Paragraph(By selector) {
        this.selector = selector;
    }

    public void getText() {
        WebElement element = DriverFactory.getInstance().findElement(selector);
        element.getText();
    }

}
