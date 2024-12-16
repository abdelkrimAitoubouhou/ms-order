package com.example.ms_order.services;

import com.example.ms_order.dto.ApiResponse;
import com.example.ms_order.dto.OrderDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

ApiResponse createOrder(OrderDto orderDto);

}
