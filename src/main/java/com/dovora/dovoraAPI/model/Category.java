package com.dovora.dovoraAPI.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Category model
 */
@Entity
@Table(name= "category")
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;

    public Category() {
        super();
    }

    public Category(String name) {
        super();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
