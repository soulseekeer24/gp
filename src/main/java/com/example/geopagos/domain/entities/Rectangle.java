package com.example.geopagos.domain.entities;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;

@Entity
@SuperBuilder
@AllArgsConstructor
public class Rectangle extends BaseGeometricShape {

    @Override
    public Double getSurfaces() {
        return base * height;
    }
}
