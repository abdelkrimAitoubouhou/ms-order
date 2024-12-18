package com.example.ms_order.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullOrderResponse {

    private Long ref;
    private String clientFirstName;
    private String clientLastName;
    private LocalDate date;
    private List<ProductDtoRs> productDtoRs;
}
