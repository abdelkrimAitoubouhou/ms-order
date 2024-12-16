package com.example.ms_order.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String mail;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();


}
