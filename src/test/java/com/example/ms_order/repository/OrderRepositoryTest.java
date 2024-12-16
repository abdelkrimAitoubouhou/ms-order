package com.example.ms_order.repository;


import com.example.ms_order.entities.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testSaveAndFindById() {
        // Arrange
        Order order = new Order();
        order.setFirstName("Alice");
        order.setLastName("Smith");
        order.setMail("alice.smith@example.com");
        order.setAddress("123 Main St");

        // Act
        Order savedOrder = orderRepository.save(order);
        Optional<Order> retrievedOrder = orderRepository.findById(savedOrder.getId());

        // Assert
        assertTrue(retrievedOrder.isPresent());
        assertEquals(savedOrder.getId(), retrievedOrder.get().getId());
        assertEquals("Alice", retrievedOrder.get().getFirstName());
    }
}
