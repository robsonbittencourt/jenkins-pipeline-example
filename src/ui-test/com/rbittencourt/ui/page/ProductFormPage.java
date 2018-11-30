package com.rbittencourt.ui.page;

import org.openqa.selenium.By;
import com.rbittencourt.ui.element.Button;
import com.rbittencourt.ui.element.TextField;
import org.openqa.selenium.WebDriver;

public class ProductFormPage {

    private WebDriver driver;

    public ProductFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public ViewProductPage create(Integer id, String description, Double price) {
        this.setId(id);
        this.setDescription(description);
        this.setPrice(price);

        return save();
    }

    public void setId(Integer id) {
        new TextField(this.driver, By.id("productId")).setText(id.toString());
    }

    public void setDescription(String description) {
        new TextField(this.driver, By.id("description")).setText(description);
    }

    public void setPrice(Double price) {
        new TextField(this.driver, By.id("price")).setText(price.toString());
    }

    public ViewProductPage save() {
        Button saveButton = new Button(this.driver, By.id("save-button"));

        saveButton.click();

        return new ViewProductPage(this.driver);
    }

}
