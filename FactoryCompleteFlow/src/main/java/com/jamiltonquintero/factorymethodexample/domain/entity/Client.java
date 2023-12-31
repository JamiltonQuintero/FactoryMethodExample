package com.jamiltonquintero.factorymethodexample.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    Long id;
    String name;
    byte age;
    String favoriteProduct;

}
