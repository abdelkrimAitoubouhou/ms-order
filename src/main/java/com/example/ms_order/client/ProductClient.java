package com.example.ms_order.client;

import com.example.ms_order.dto.ProductDtoRs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "${application.config.products-url}")
public interface ProductClient {

    @GetMapping("/order/{order_id}")
    List<ProductDtoRs> getAllProductByOrderId(@PathVariable("order_id") Long orderId);



    }
