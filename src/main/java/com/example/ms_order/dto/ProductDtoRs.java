package com.example.ms_order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDtoRs {

    private Long id;
    private String model;
    private Double price;
    private Integer qte;
    private String status;
    private Long orderId;


}
