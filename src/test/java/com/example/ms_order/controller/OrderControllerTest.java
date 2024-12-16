package com.example.ms_order.controller;

import com.example.ms_order.dto.ApiResponse;
import com.example.ms_order.dto.OrderDto;
import com.example.ms_order.dto.ProductDto;
import com.example.ms_order.services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    private OrderDto orderDto;
    private ApiResponse apiResponse;

    @BeforeEach
    void setUp() {
        // Mock OrderDto
        orderDto = new OrderDto();
        orderDto.setFirstName("John");
        orderDto.setLastName("Doe");
        orderDto.setMail("john.doe@example.com");
        orderDto.setAddress("123 Main St");

        // Mock ApiResponse
        apiResponse = ApiResponse.builder()
                .id(1L)
                .message("The order has saved successfully")
                .build();
    }

    @Test
    void testCreateOrder() throws Exception {
        // Add a non-empty products list to satisfy validation constraints
        List<ProductDto> products = new ArrayList<>();
        ProductDto product = new ProductDto();
        product.setId(1L);
        product.setModel("Product Model");
        product.setQte(BigDecimal.valueOf(2));
        product.setPrice(100.0);
        product.setStatus("available");
        products.add(product);

        orderDto.setProducts(products); // Set the products list

        // Mock the service response
        Mockito.when(orderService.createOrder(any(OrderDto.class))).thenReturn(apiResponse);

        // Perform POST request
        mockMvc.perform(post("/order/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.message").value("The order has saved successfully"));
    }


}
