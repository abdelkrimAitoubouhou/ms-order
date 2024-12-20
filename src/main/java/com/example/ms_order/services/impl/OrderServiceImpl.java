package com.example.ms_order.services.impl;

import com.example.ms_order.client.ProductClient;
import com.example.ms_order.dto.ApiResponse;
import com.example.ms_order.dto.OrderDto;
import com.example.ms_order.dto.ProductDtoRs;
import com.example.ms_order.entities.Order;
import com.example.ms_order.mappers.OrderMapper;
import com.example.ms_order.repository.OrderRepository;
import com.example.ms_order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

        //check if the product exist
        ProductDtoRs dtoRs = client.getProduct(order.getProductId());
        if (Objects.isNull(dtoRs))
            throw new RuntimeException("Product not found with id : " + order.getProductId());

        //check if the product available
        boolean productCheckResult = client.checkProduct(order.getProductId(), order.getProductQte());

        if (!productCheckResult) {
            return ApiResponse.builder()
                    .message("Order failed")
                    .build();
        }

        //set the product out of the stock
        var verify = client.enableOrDisableProduct(order.getProductId());
         if (!verify) throw new RuntimeException("Product should be not available");

        //confirm order request
        orderRepository.save(order);
        return ApiResponse.builder()
                .id(order.getRef())
                .message("The order has been saved successfully")
                .build();
    }



}
