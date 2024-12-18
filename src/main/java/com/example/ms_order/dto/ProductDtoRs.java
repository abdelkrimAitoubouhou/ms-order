package com.example.ms_order.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoRs {

    @NotNull
    private Long id;

    @NotEmpty
    private String model;

    @NotNull
    private BigDecimal qte;

    @NotNull
    private Double price;

    @NotEmpty
    private String status = "available";

}
