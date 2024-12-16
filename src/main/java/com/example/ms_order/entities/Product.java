package com.example.ms_order.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private BigDecimal qte;
    private Double price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
