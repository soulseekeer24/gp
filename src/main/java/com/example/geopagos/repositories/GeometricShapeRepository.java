package com.example.geopagos.repositories;

import com.example.geopagos.domain.entities.BaseGeometricShape;
import com.example.geopagos.domain.enums.GeometricType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeometricShapeRepository extends CrudRepository<BaseGeometricShape, Long> {
    List<BaseGeometricShape> findAllByGeometricType(GeometricType geometricType);
}
