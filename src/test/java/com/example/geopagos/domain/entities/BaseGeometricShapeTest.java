package com.example.geopagos.domain.entities;

import com.example.geopagos.domain.enums.GeometricType;
import com.example.geopagos.domain.factories.GeometricShapeFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BaseGeometricShapeTest {

    final double TOLERANCE = 0.01d;

    @Test
    @DisplayName("Test should return the expected values(base,height,surfaces) for Circle")
    void getSurfacesForCircle() {
        // Arrange
        final Double expected = 50.26;
        final Double expectedDiameter = 8d;
        final BaseGeometricShape circle = new GeometricShapeFactory()
                .buildShape(GeometricType.CIRCLE,
                        8d, null, null);
        // Act
        double actual = circle.getSurfaces();

        // Assert
        assertEquals(expected, actual, TOLERANCE);
        assertEquals(expectedDiameter, circle.getDiameter());
        assertEquals(null, circle.getHeight());
        assertEquals(null, circle.getBase());

    }

    @Test
    @DisplayName("Test should throw and IllegalArgumentException when Diameter is null")
    void getSurfacesForCircle_Fail() {
        // Arrange
        String expectedMessage = "Diameter must be provided";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new GeometricShapeFactory()
                    .buildShape(GeometricType.CIRCLE,
                            null, null, null);
        });

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
    }

    @Test
    @DisplayName("Test should return the expected values(base,height,surfaces) for RECTANGLE")
    void getSurfacesForRectangle() {
        // Arrange
        final Double expected = 20d;
        final Double expectedBase = 4d;
        final Double expectedHeight = 5d;
        final BaseGeometricShape rectangle = new GeometricShapeFactory()
                .buildShape(GeometricType.RECTANGLE,
                        null, 4d, 5d);
        // Act
        double actual = rectangle.getSurfaces();

        // Assert
        assertEquals(expected, actual, TOLERANCE);
        assertEquals(expectedBase, rectangle.getBase(), TOLERANCE);
        assertEquals(expectedHeight, rectangle.getHeight(), TOLERANCE);
        assertEquals(null, rectangle.getDiameter());

    }

    @Test
    @DisplayName("Test should throw and IllegalArgumentException when base or height is null")
    void getSurfacesForRectangle_Fail() {
        // Arrange
        String expectedMessage = "Base and Height must be provided";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new GeometricShapeFactory()
                    .buildShape(GeometricType.RECTANGLE,
                            null, null, null);
        });

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
    }

    @Test
    @DisplayName("Test should return the expected values(base,height,surfaces) for TRIANGLE")
    void getSurfacesForTriangle() {
        // Arrange
        final Double expected = 8d;
        final Double expectedBase = 4d;
        final Double expectedHeight = 4d;
        final BaseGeometricShape triangle = new GeometricShapeFactory()
                .buildShape(GeometricType.TRIANGLE,
                        null, 4d, 4d);
        // Act
        double actual = triangle.getSurfaces();

        // Assert
        assertEquals(expected, actual, TOLERANCE);
        assertEquals(expectedBase, triangle.getBase(), TOLERANCE);
        assertEquals(expectedHeight, triangle.getHeight(), TOLERANCE);
        assertEquals(null, triangle.getDiameter());
    }

    @Test
    @DisplayName("Test should throw and IllegalArgumentException when base or height is null")
    void getSurfacesForTriangle_Fail() {
        // Arrange
        String expectedMessage = "Base and Height must be provided";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new GeometricShapeFactory()
                    .buildShape(GeometricType.TRIANGLE,
                            null, null, null);
        });

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
    }
}