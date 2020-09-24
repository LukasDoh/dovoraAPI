package com.dovora.dovoraAPI.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Customer model
 */
@Entity
@SequenceGenerator(name="custIdSeq", initialValue = 5001, allocationSize = 1)
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custIdSeq")
    private long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String street;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName, String street, String zipCode, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
