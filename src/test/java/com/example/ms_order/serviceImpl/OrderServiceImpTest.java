package com.example.ms_order.serviceImpl;

import com.example.ms_order.dto.ApiResponse;
import com.example.ms_order.dto.OrderDto;
import com.example.ms_order.entities.Order;
import com.example.ms_order.mappers.OrderMapper;
import com.example.ms_order.repository.OrderRepository;
import com.example.ms_order.services.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceImpTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderServiceImpl orderService;

    private OrderDto orderDto;
    private Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock data
        orderDto = new OrderDto();
        orderDto.setFirstName("John");
        orderDto.setLastName("Doe");
        orderDto.setMail("john.doe@example.com");

        order = new Order();
        order.setId(1L);
        order.setFirstName("John");
        order.setLastName("Doe");
        order.setMail("john.doe@example.com");
    }

    @Test
    void testCreateOrder() {
        // Mock behavior
        when(orderMapper.toEntity(orderDto)).thenReturn(order);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        // Execute service method
        ApiResponse response = orderService.createOrder(orderDto);

        // Verify interactions
        verify(orderMapper, times(1)).toEntity(orderDto);
        verify(orderRepository, times(1)).save(order);

        // Assert response
        assertEquals(1L, response.getId());
        assertEquals("The order has saved successfully", response.getMessage());
    }
}
