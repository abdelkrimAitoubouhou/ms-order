package com.example.ms_order.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {


    private Long ref;

    @NotNull
    private LocalDate date;

    @NotEmpty
    private String clientFirstName;

    @NotEmpty
    private String clientLastName;

    @NotEmpty
    private String address;
}
