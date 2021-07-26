package com.rbittencourt.ui.page;

import com.rbittencourt.ui.element.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage {

    private WebDriver driver;
    private Menu menu;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        this.menu = new Menu(driver);
    }

    public ProductListPage goTo() {
        this.driver.get("http://app-uat:8085");
        return this;
    }

    public Menu getMenu() {
        return menu;
    }

    public boolean createProductIsVisible() {
        Link link = new Link(this.driver, By.xpath("//a[@href='/product/new']"));
        return link.isVisible();
    }

    public ViewProductPage create(int id, String description, double price) {
        Link link = new Link(this.driver, By.xpath("//a[@href='/product/new']"));

        link.click();

        ProductFormPage formPage = new ProductFormPage(this.driver);
        return formPage.create(id, description, price);
    }

    public ViewProductPage view(String id) {
        Link link = new Link(this.driver, By.xpath("//a[@href='/product/" + id + "']"));

        link.click();

        return new ViewProductPage(this.driver);
    }

    public ProductFormPage edit(String id) {
        Link link = new Link(this.driver, By.xpath("//a[@href='/product/edit/" + id + "']"));

        link.click();

        return new ProductFormPage(this.driver);
    }

}
