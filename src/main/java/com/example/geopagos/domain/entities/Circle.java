package com.example.geopagos.domain.entities;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@AllArgsConstructor
public class Circle extends BaseGeometricShape {

    @Override
    public Double getSurfaces() {
        return Math.PI * Math.pow(diameter / 2, 2);
    }
}
