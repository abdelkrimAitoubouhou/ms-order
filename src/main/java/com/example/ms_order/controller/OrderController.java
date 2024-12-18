package com.example.ms_order.controller;

import com.example.ms_order.dto.ApiResponse;
import com.example.ms_order.dto.FullOrderResponse;
import com.example.ms_order.dto.OrderDto;
import com.example.ms_order.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/create")
    ApiResponse createOrder(@RequestBody @Valid OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/with-products/{order-id}")
    FullOrderResponse getOrderByIdWithProducts(@PathVariable("order-id") Long orderId) {
        return orderService.getOrderByIdWithProducts(orderId);
    }

}
