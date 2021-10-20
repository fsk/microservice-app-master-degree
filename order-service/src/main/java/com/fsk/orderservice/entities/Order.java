package com.fsk.orderservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OrderTbl")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long price;
}
