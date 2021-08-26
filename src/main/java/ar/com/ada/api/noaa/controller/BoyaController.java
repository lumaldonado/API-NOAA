package ar.com.ada.api.noaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.models.request.BoyaSinMuestras;
import ar.com.ada.api.noaa.models.request.ColorNuevoLuz;
import ar.com.ada.api.noaa.models.response.GenericResponse;
import ar.com.ada.api.noaa.services.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    BoyaService service;

    @PostMapping("/boyas")
    public ResponseEntity<?> crearBoya(@RequestBody Boya boya){
        service.crearBoya(boya);

        GenericResponse respuesta = new GenericResponse();
        respuesta.isOk = true;
        respuesta.id = boya.getId();
        respuesta.message = "La boya fue creado con exito";

        return ResponseEntity.ok(respuesta);
    }


    @GetMapping("/boyas)")
    public ResponseEntity<List<Boya>> getBoyasSinMuestras(){
        return ResponseEntity.ok(service.traerBoyasSinMuestras());
    }

    @GetMapping("/boyas/{id}")
    public ResponseEntity<?> getBoyasPorId(@PathVariable Integer id){
        Boya boyas = service.buscarPorId(id);
        if (boyas == null){
            return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(boyas);
    }


    @PutMapping("/boyas/{id}")
    public ResponseEntity<GenericResponse> modificarBoyaId(@PathVariable Integer id, @RequestBody ColorNuevoLuz colorNuevo){
        Boya boya = service.buscarPorId(id);
        boya.setColorLuz(colorNuevo.colorLuz);
        service.guardar(boya);

     GenericResponse respuesta = new GenericResponse();
     respuesta.isOk = true;
     respuesta.message = "Color actualizado";
     return ResponseEntity.ok(respuesta);
 
    }
    

}
