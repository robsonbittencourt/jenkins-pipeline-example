package com.rbittencourt.ui.test;

import com.rbittencourt.ui.driver.DriverFactory;
import com.rbittencourt.ui.page.ProductListPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProductUiEditUiTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = DriverFactory.getInstance();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldNavigateBetweenPagesUsingMenu() {
        // for is just for demonstration
        for (int i = 0; i < 1; i++) {
            ProductListPage productListPage = new ProductListPage(driver).goTo();
            productListPage.getMenu().goToCreatePage();
            productListPage = productListPage.getMenu().goToListPage();

            assertTrue(productListPage.createProductIsVisible());
        }
    }

}
