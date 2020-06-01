package com.example.geopagos.domain.factories;

import com.example.geopagos.domain.entities.BaseGeometricShape;
import com.example.geopagos.domain.entities.Circle;
import com.example.geopagos.domain.entities.Rectangle;
import com.example.geopagos.domain.entities.Triangle;
import com.example.geopagos.domain.enums.GeometricType;

public abstract class AbstractGeometricShapeFactory {

    public abstract BaseGeometricShape buildShape(GeometricType geometricType, Double diameter, Double base, Double height);

    protected abstract Circle buildCircle(Double diameter);

    protected abstract Triangle buildTriangle(Double base, Double height);

    protected abstract Rectangle buildRectangle(Double base, Double height);

}
