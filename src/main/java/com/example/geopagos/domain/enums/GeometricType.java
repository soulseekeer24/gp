package com.example.geopagos.domain.enums;


import com.example.geopagos.domain.interfaces.GeometricShape;
import lombok.Getter;

import java.util.function.Function;

@Getter
public enum GeometricType {
    CIRCLE("Circle", GeometricShape::getSurfaces),
    RECTANGLE("Rectangle", GeometricShape::getSurfaces),
    TRIANGLE("Triangle", GeometricShape::getSurfaces);

    private final String name;
    private final Function<GeometricShape, Double> computeSurface;

    GeometricType(String name, Function<GeometricShape, Double> computeSurface) {
        this.name = name;
        this.computeSurface = computeSurface;
    }
}
