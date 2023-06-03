package com.belajarspringboot.resto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade= {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
            mappedBy = "tags"
    )
    @JsonIgnore
    private Set<Product> products = new HashSet<>();
    public Tag() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
