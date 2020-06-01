package com.example.geopagos.domain.entities;

import com.example.geopagos.domain.enums.GeometricType;
import com.example.geopagos.domain.interfaces.GeometricShape;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@SuperBuilder
@Entity
@NoArgsConstructor
public abstract class BaseGeometricShape implements GeometricShape {

    @Id
    @GeneratedValue
    protected Long id;
    protected Double height;
    protected Double base;
    protected Double diameter;
    protected GeometricType geometricType;

    @Override
    public Double getBase() {
        return base;
    }

    @Override
    public Double getHeight() {
        return height;
    }

    @Override
    public GeometricType getGeometricType() {
        return geometricType;
    }

    @Override
    public Double getDiameter() {
        return diameter;
    }

    @Override
    public Double getSurfaces() {
        return this.geometricType.getComputeSurface().apply(this);
    }

    public Long getId() {
        return id;
    }

}
