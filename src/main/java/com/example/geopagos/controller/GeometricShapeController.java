package com.example.geopagos.controller;

import com.example.geopagos.domain.enums.GeometricType;
import com.example.geopagos.facade.GeometricShapeFacade;
import com.example.geopagos.facade.dto.CreateShapeDTO;
import com.example.geopagos.facade.dto.GeometricShapeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.websocket.server.PathParam;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("geometric-shapes")
@RestController
public class GeometricShapeController {

    private final GeometricShapeFacade geometricShapeFacade;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public GeometricShapeDTO createShape(@RequestBody CreateShapeDTO createShapeDTO) {
        return geometricShapeFacade.create(createShapeDTO);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public List<GeometricShapeDTO> findAll() {
        return geometricShapeFacade.findAll();
    }


    @RequestMapping(path = "/{type}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public List<GeometricShapeDTO> findAllByType(@PathVariable GeometricType type) {
        return geometricShapeFacade.findAllByType(type);
    }


    // TODO: solo por simplicidad aca un devuelvo los errores en un mensaje estoy asumiendo que
    // los unicos errores q puedne haber ne la aplicacion son los IllegalArgument cuando creo las figuras
    // que deberian ser errores mas especifico pero por no extender el ejercicio lo dejamos asi
    @ControllerAdvice
    class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value = {IllegalArgumentException.class})
        protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
            return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        }
    }

}
