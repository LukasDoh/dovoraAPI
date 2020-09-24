package com.dovora.dovoraAPI.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Article model
 */
@Entity
@SequenceGenerator(name="idSeq", initialValue = 1001, allocationSize = 1)
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeq")
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private float price;

    @NotBlank
    private String category;

    public Article() {
        super();
    }

    public Article(Long id, String name, float price, String category) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
