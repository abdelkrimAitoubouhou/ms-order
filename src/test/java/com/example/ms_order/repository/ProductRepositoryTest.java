package com.example.ms_order.repository;


import com.example.ms_order.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveAndFindById() {
        // Arrange
        Product product = new Product();
        product.setModel("Laptop X100");
        product.setPrice(1000.0);
        product.setStatus("available");
        product.setQte(BigDecimal.valueOf(10));

        // Act
        Product savedProduct = productRepository.save(product);
        Optional<Product> retrievedProduct = productRepository.findById(savedProduct.getId());

        // Assert
        assertTrue(retrievedProduct.isPresent());
        assertEquals(savedProduct.getId(), retrievedProduct.get().getId());
        assertEquals("Laptop X100", retrievedProduct.get().getModel());
    }
}
