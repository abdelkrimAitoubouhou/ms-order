package com.example.ms_order.client;

import com.example.ms_order.dto.ProductDto;
import com.example.ms_order.dto.ProductDtoRs;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "ms-inventory") //we don't need to define the url of this ms cuz eureka will discover it
public interface ProductClient {

    @GetMapping("/product/order/{order_id}") //it's necessary to define the Controller mapping in every endpoint
    @CircuitBreaker(name = "inventoryServiceCB", fallbackMethod = "fallbackGetAllProductByOrderId")
    List<ProductDto> getAllProductByOrderId(@PathVariable("order_id") Long orderId);

    @GetMapping("/product/check-product/{product_id}/{product_qte}")
    @CircuitBreaker(name = "inventoryServiceCB", fallbackMethod = "fallbackCheckProduct")
    boolean checkProduct(@PathVariable("product_id") Long id,
                         @PathVariable("product_qte") Integer qte);

    @GetMapping("/product/get")
    @CircuitBreaker(name = "inventoryServiceCB", fallbackMethod = "fallbackGetProduct")
    ProductDtoRs getProduct(@RequestParam Long id);

    @GetMapping("/product/availability/{product_id}")
    @CircuitBreaker(name = "inventoryServiceCB", fallbackMethod = "fallbackEnableOrDisableProduct")
    boolean enableOrDisableProduct(@PathVariable("product_id") Long id);


    // Methods of fallback
    default List<ProductDto> fallbackGetAllProductByOrderId(Long orderId, Throwable throwable) {
        return Collections.emptyList();
    }

    default boolean fallbackCheckProduct(Long id, Integer qte, Throwable throwable) {
        return false;
    }

    default ProductDtoRs fallbackGetProduct(Long id, Throwable throwable) {
        return ProductDtoRs.builder()
                .id(id)
                .model("default model")
                .orderId(null)
                .price(null)
                .qte(null)
                .build();
    }

    default boolean fallbackEnableOrDisableProduct(Long id, Throwable throwable) {
        return false;
    }


}
