package com.workintech.burgerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "burger" , schema = "public")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "vegan")
    private boolean isVegan;

    @Column(name = "bread_type")
    private String breadType;

    @Column(name = "contents")
    private String contents;
}
