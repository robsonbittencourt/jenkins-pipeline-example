package com.rbittencourt.repositories;

import com.rbittencourt.configuration.RepositoryConfiguration;
import com.rbittencourt.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryIT {

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    public void setUp() {
        productRepository.deleteAll();

        product = new Product();
        product.setDescription("Camisa");
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("1234");

        productRepository.save(product);
        assertNotNull(product.getId());
    }

    @Test
    public void shouldFetchProduct(){
        Product fetchedProduct = productRepository.findById(product.getId()).orElse(null);

        assertNotNull(fetchedProduct);
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());
    }

    @Test
    public void shouldUpdateProduct() {
        Product fetchedProduct = productRepository.findById(product.getId()).orElse(null);
        fetchedProduct.setDescription("New Description");
        productRepository.save(fetchedProduct);

        Product fetchedUpdatedProduct = productRepository.findById(fetchedProduct.getId()).orElse(null);
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());
    }

    @Test
    public void shouldCountProducts() {
        long productCount = productRepository.count();
        assertEquals(productCount, 1);
    }

    @Test
    public void shoulCountAllProducts() {
        Iterable<Product> products = productRepository.findAll();

        int count = 0;

        for(Product p : products){
            count++;
        }

        assertEquals(count, 1);
    }
}
