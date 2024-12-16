package com.example.ms_order.services.impl;

import com.example.ms_order.dto.ApiResponse;
import com.example.ms_order.dto.OrderDto;
import com.example.ms_order.entities.Order;
import com.example.ms_order.mappers.OrderMapper;
import com.example.ms_order.repository.OrderRepository;
import com.example.ms_order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public ApiResponse createOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        orderRepository.save(order);
        return ApiResponse.builder()
                .id(order.getId())
                .message("The order has saved successfully")
                .build();
    }
}
