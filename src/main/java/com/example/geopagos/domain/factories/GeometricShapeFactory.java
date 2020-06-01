package com.example.geopagos.domain.factories;


import com.example.geopagos.domain.entities.BaseGeometricShape;
import com.example.geopagos.domain.entities.Circle;
import com.example.geopagos.domain.entities.Rectangle;
import com.example.geopagos.domain.entities.Triangle;
import com.example.geopagos.domain.enums.GeometricType;


public class GeometricShapeFactory extends AbstractGeometricShapeFactory {


    @Override
    public BaseGeometricShape buildShape(GeometricType geometricType, Double diameter, Double base, Double height) {
        switch (geometricType) {
            case CIRCLE:
                return buildCircle(diameter);
            case RECTANGLE:
                return buildRectangle(base, height);
            case TRIANGLE:
                return buildTriangle(base, height);
            default:
                throw new IllegalArgumentException("Invalid type...");
        }
    }


    @Override
    protected Circle buildCircle(Double diameter) {

        if (diameter == null) {
            throw new IllegalArgumentException("Diameter must be provided");
        }

        return Circle.builder()
                .geometricType(GeometricType.CIRCLE)
                .diameter(diameter)
                .build();
    }

    @Override
    protected Triangle buildTriangle(Double base, Double height) {

        if (base == null || height == null) {
            throw new IllegalArgumentException("Base and Height must be provided");
        }

        return Triangle.builder()
                .base(base)
                .height(height)
                .geometricType(GeometricType.TRIANGLE)
                .build();
    }

    @Override
    protected Rectangle buildRectangle(Double base, Double height) {

        if (base == null || height == null) {
            throw new IllegalArgumentException("Base and Height must be provided");
        }

        return Rectangle.builder()
                .base(base)
                .height(height)
                .geometricType(GeometricType.RECTANGLE)
                .build();
    }

}
