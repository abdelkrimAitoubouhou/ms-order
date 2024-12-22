package com.example.ms_order.client;

import com.example.ms_order.dto.ProductDto;
import com.example.ms_order.dto.ProductDtoRs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-inventory") //we don't need to define the url of this ms cuz eureka will discover it
public interface ProductClient {

    @GetMapping("/product/order/{order_id}") //it's necessary to define the Controller mapping in every endpoint
    List<ProductDto> getAllProductByOrderId(@PathVariable("order_id") Long orderId);

    @GetMapping("/product/check-product/{product_id}/{product_qte}")
    boolean checkProduct(@PathVariable("product_id") Long id,
                         @PathVariable("product_qte") Integer qte);

    @GetMapping("/product/get")
    ProductDtoRs getProduct(@RequestParam Long id);

    @GetMapping("/product/availability/{product_id}")
    boolean enableOrDisableProduct(@PathVariable("product_id") Long id);


}
