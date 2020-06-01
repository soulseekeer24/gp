package com.example.geopagos.facade.dto;

import com.example.geopagos.domain.enums.GeometricType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class CreateShapeDTO {
    private final GeometricType geometricType;
    private final Double diameter;
    private final Double base;
    private final Double height;
}
