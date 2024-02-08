package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ITEMS")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "items")
    private Cart cart;
}
