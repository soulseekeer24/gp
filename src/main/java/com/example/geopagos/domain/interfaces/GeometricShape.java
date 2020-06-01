package com.example.geopagos.domain.interfaces;

import com.example.geopagos.domain.enums.GeometricType;

public interface GeometricShape {


    Double getSurfaces();

    Double getBase();

    Double getHeight();

    Double getDiameter();

    GeometricType getGeometricType();


}
