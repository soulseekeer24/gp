package com.example.geopagos.facade;

import com.example.geopagos.domain.enums.GeometricType;
import com.example.geopagos.facade.dto.CreateShapeDTO;
import com.example.geopagos.facade.dto.GeometricShapeDTO;

import java.util.List;

public interface GeometricShapeFacade {

     GeometricShapeDTO create(CreateShapeDTO createShapeDTO);

    List<GeometricShapeDTO> findAll();

    List<GeometricShapeDTO> findAllByType(GeometricType type);
}
