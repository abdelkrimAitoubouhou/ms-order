package com.example.ms_order.client;

import com.example.ms_order.dto.ProductDto;
import com.example.ms_order.dto.ProductDtoRs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-service", url = "${application.config.products-url}")
public interface ProductClient {

    @GetMapping("/order/{order_id}")
    List<ProductDto> getAllProductByOrderId(@PathVariable("order_id") Long orderId);

    @GetMapping("/check-product/{product_id}/{product_qte}")
    boolean checkProduct(@PathVariable("product_id") Long id,
                         @PathVariable("product_qte") Integer qte);

    @GetMapping("/get")
    ProductDtoRs getProduct(@RequestParam Long id);

    @GetMapping("/availability/{product_id}")
    boolean enableOrDisableProduct(@PathVariable("product_id") Long id);


}
