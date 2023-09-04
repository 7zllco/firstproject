package com.example.firstproject.entity;

import jakarta.persistence.*;


@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String price;
}
