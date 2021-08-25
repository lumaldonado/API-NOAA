package ar.com.ada.api.noaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.services.MuestraService;

@RestController
public class MuestraController {

    @Autowired
    MuestraService service;

    @PostMapping("/muestras")

    @GetMapping("/muestras/boyas/{idBoya}")

    @GetMapping("/muestras/colores/{color}")

    @GetMapping("muestras/minima/{idBoya}")

    @DeleteMapping("/muestras/{id}")
    
}
