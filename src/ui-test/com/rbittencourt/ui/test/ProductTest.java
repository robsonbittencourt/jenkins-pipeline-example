package com.rbittencourt.ui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import com.rbittencourt.ui.driver.DriverFactory;
import com.rbittencourt.ui.page.ProductFormPage;
import com.rbittencourt.ui.page.ProductListPage;
import com.rbittencourt.ui.page.ViewProductPage;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getInstance();
    }

    @Before
    public void setupTest() {
        driver = DriverFactory.getInstance();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldCreateProduct() {
        // for is just for demonstration
        for (int i = 0; i < 30; i++) {
            String description = "ball";

            ProductListPage productListPage = new ProductListPage().goTo();

            ViewProductPage viewProductPage = productListPage.create(3, description, 10.50);

            assertEquals(description, viewProductPage.getDescription());
            assertEquals("10.50", viewProductPage.getPrice());
        }
    }

    @Test
    public void shouldEditProduct() {
        // for is just for demonstration
        for (int i = 0; i < 30; i++) {
            String description = "shoe";
            String newDescription = "new shoe";

            double price = 10.50;
            double newPrice = 14.60;

            ProductListPage productListPage = new ProductListPage().goTo();
            ViewProductPage viewProductPage = productListPage.create(3, description, price);
            String newId = viewProductPage.getId();

            productListPage = viewProductPage.getMenu().goToListPage();
            ProductFormPage productFormPage = productListPage.edit(newId);
            productFormPage.setDescription(newDescription);
            productFormPage.setPrice(newPrice);
            viewProductPage = productFormPage.save();

            productListPage = viewProductPage.getMenu().goToListPage();
            viewProductPage = productListPage.view(newId);

            assertEquals(newId, viewProductPage.getId());
            assertEquals(newDescription, viewProductPage.getDescription());
            assertEquals("14.60", viewProductPage.getPrice());
        }
    }

}
