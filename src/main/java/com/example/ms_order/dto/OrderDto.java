package com.example.ms_order.dto;

import com.example.ms_order.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Long ref;
    private String name;
    private String address;
    private String mail;
    private List<Product> products;
}
