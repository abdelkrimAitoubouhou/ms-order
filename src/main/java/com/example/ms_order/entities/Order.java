package com.example.ms_order.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_table")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ref;
    private LocalDate date;
    private String clientFirstName;
    private String clientLastName;
    private String address;

    private Long productId;
    private Integer productQte;

}
