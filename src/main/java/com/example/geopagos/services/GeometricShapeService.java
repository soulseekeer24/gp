package com.example.geopagos.services;

import com.example.geopagos.domain.entities.BaseGeometricShape;
import com.example.geopagos.domain.enums.GeometricType;

import java.util.List;
import java.util.Optional;

public interface GeometricShapeService {

    List<BaseGeometricShape> getAll();

    BaseGeometricShape save(BaseGeometricShape shape);

    Optional<BaseGeometricShape> getById(Long id);

    List<BaseGeometricShape> getByType(GeometricType geometricType);

}
