package com.example.ms_order.services.impl;

import com.example.ms_order.client.ProductClient;
import com.example.ms_order.dto.ApiResponse;
import com.example.ms_order.dto.FullOrderResponse;
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
    private final ProductClient client;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderMapper orderMapper, ProductClient client) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.client = client;
    }

    @Override
    public ApiResponse createOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        orderRepository.save(order);
        return ApiResponse.builder()
                .id(order.getRef())
                .message("The order has saved successfully")
                .build();
    }

    @Override
    public FullOrderResponse getOrderByIdWithProducts(Long orderId) {
        var order = orderRepository.findById(orderId).orElseThrow(() ->
                new RuntimeException("Order not found with id : " + orderId));

        var products = client.getAllProductByOrderId(orderId);
        return FullOrderResponse.builder()
                .ref(order.getRef())
                .clientFirstName(order.getClientFirstName())
                .clientLastName(order.getClientLastName())
                .date(order.getDate())
                .productDtoRs(products)
                .build();
    }
}
