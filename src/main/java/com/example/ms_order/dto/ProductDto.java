package com.example.ms_order.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotNull
    private Long id;

    @NotEmpty
    private String model;

    @NotNull
    private Integer qte;

    @NotNull
    private Double price;

    private String status = "available";


}
