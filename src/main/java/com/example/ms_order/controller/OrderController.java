package com.example.ms_order.controller;

import com.example.ms_order.dto.ApiResponse;
import com.example.ms_order.dto.OrderDto;
import com.example.ms_order.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/hey")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<String> sayHelloToAdmin() {
        return ResponseEntity.ok("Hey Admin");
    }

    @GetMapping("/hello")
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<String> sayHelloToUser() {
        return ResponseEntity.ok("Hello User");
    }


}
