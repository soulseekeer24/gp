package com.example.geopagos.facade.impl;

import com.example.geopagos.domain.entities.BaseGeometricShape;
import com.example.geopagos.domain.enums.GeometricType;
import com.example.geopagos.domain.factories.GeometricShapeFactory;
import com.example.geopagos.facade.dto.GeometricShapeDTO;
import com.example.geopagos.facade.GeometricShapeFacade;
import com.example.geopagos.facade.dto.CreateShapeDTO;
import com.example.geopagos.services.GeometricShapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GeometricShapeFacadeImpl implements GeometricShapeFacade {

    private final GeometricShapeService geometricShapeService;

    @Override
    public GeometricShapeDTO create(CreateShapeDTO createShapeDTO) {
        final GeometricShapeFactory factory = new GeometricShapeFactory();

        final BaseGeometricShape geometricShape = factory.buildShape(
                createShapeDTO.getGeometricType(),
                createShapeDTO.getDiameter(),
                createShapeDTO.getBase(),
                createShapeDTO.getHeight());

        return GeometricShapeDTO.of(geometricShapeService.save(geometricShape));
    }

    @Override
    public List<GeometricShapeDTO> findAll() {
        return geometricShapeService.getAll()
                .stream()
                .map(GeometricShapeDTO::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<GeometricShapeDTO> findAllByType(GeometricType type) {
        return geometricShapeService.getByType(type)
                .stream()
                .map(GeometricShapeDTO::of)
                .collect(Collectors.toList());
    }


}
