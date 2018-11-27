package com.rbittencourt.ui.page;

import org.openqa.selenium.By;

import com.rbittencourt.ui.element.Button;
import com.rbittencourt.ui.element.TextField;

public class ProductFormPage {

    public ViewProductPage create(Integer id, String description, Double price) {
        this.setId(id);
        this.setDescription(description);
        this.setPrice(price);

        return save();
    }

    public void setId(Integer id) {
        new TextField(By.id("productId")).setText(id.toString());
    }

    public void setDescription(String description) {
        new TextField(By.id("description")).setText(description);
    }

    public void setPrice(Double price) {
        new TextField(By.id("price")).setText(price.toString());
    }

    public ViewProductPage save() {
        Button saveButton = new Button(By.id("save-button"));

        saveButton.click();

        return new ViewProductPage();
    }

}
