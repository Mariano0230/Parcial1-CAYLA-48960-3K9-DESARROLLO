package com.example.api_rest.controller;

import com.example.api_rest.model.Estadsiticas;
import com.example.api_rest.service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class EstadisticasController {
    @Autowired
    private EstadisticaService EstadisticasService;
    @GetMapping
    public ResponseEntity<Estadsiticas> getStats() {
        Estadsiticas estadsiticas = EstadisticasService.getEstadisticas  ();
        if (estadsiticas != null) {
            System.out.println("Datos encontrados :)");
            return new ResponseEntity<>(estadsiticas, HttpStatus.OK);
        } else {
            System.out.println("Datos no encontrados");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
