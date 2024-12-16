package com.example.ms_order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String model;
    private BigDecimal qte;
    private Boolean price;
    private String status;

    private Long orderId;

}
