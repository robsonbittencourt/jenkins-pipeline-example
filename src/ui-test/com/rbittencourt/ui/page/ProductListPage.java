package com.rbittencourt.ui.page;

import org.openqa.selenium.By;

import com.rbittencourt.ui.driver.DriverFactory;
import com.rbittencourt.ui.element.Link;

public class ProductListPage {

    public ProductListPage goTo() {
        DriverFactory.getInstance().get("http://localhost:8080");
        return this;
    }

    public ViewProductPage create(int id, String description, double price) {
        Link link = new Link(By.xpath("//a[@href='/product/new']"));

        link.click();

        ProductFormPage formPage = new ProductFormPage();
        return formPage.create(id, description, price);
    }

    public ViewProductPage view(String id) {
        Link link = new Link(By.xpath("//a[@href='/product/" + id + "']"));

        link.click();

        return new ViewProductPage();
    }

    public ProductFormPage edit(String id) {
        Link link = new Link(By.xpath("//a[@href='/product/edit/" + id + "']"));

        link.click();

        return new ProductFormPage();
    }

}
