package com.adhessit.rems.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String country;
    String country_code;
    String county;
    String postcode;
    String state;
    String state_district;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", country_code='" + country_code + '\'' +
                ", county='" + county + '\'' +
                ", postcode='" + postcode + '\'' +
                ", state='" + state + '\'' +
                ", state_district='" + state_district + '\'' +
                '}';
    }
}
