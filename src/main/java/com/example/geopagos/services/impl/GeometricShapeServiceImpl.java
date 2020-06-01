package com.example.geopagos.services.impl;

import com.example.geopagos.domain.entities.BaseGeometricShape;
import com.example.geopagos.domain.enums.GeometricType;
import com.example.geopagos.domain.interfaces.GeometricShape;
import com.example.geopagos.repositories.GeometricShapeRepository;
import com.example.geopagos.services.GeometricShapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GeometricShapeServiceImpl implements GeometricShapeService {

    private final GeometricShapeRepository geometricShapeRepository;

    @Override

    public List<BaseGeometricShape> getAll() {
        return (List<BaseGeometricShape>) geometricShapeRepository.findAll();
    }

    @Override
    public BaseGeometricShape save(BaseGeometricShape shape) {
        return geometricShapeRepository.save(shape);
    }

    @Override
    public Optional<BaseGeometricShape> getById(Long id) {
        return geometricShapeRepository.findById(id);
    }

    @Override
    public List<BaseGeometricShape> getByType(GeometricType geometricType) {
        return geometricShapeRepository.findAllByGeometricType(geometricType);
    }
}
