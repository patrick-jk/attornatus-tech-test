package com.attornatus.techtest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String zip;
    private int number;
    private String city;
    @JsonProperty("is_main_address")
    private boolean isMainAddress;
    @ManyToOne
    private Person person;
}