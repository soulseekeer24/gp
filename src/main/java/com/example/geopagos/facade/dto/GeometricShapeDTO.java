package com.example.geopagos.facade.dto;

import com.example.geopagos.domain.entities.BaseGeometricShape;
import com.example.geopagos.domain.enums.GeometricType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeometricShapeDTO {
    private final Long id;
    private final Double height;
    private final Double base;
    private final Double diameter;
    private final Double surface;
    private final GeometricType geometricType;

    public static GeometricShapeDTO of(BaseGeometricShape shape) {
        return GeometricShapeDTO.builder()
                .id(shape.getId())
                .height(shape.getHeight())
                .base(shape.getBase())
                .diameter(shape.getDiameter())
                .geometricType(shape.getGeometricType())
                .surface(shape.getSurfaces())
                .build();
    }
}
