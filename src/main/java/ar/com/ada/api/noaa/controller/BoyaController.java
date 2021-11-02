package ar.com.ada.api.noaa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.models.request.ColorNuevoLuz;
import ar.com.ada.api.noaa.models.request.InfoBoyaNueva;
import ar.com.ada.api.noaa.models.response.GenericResponse;
import ar.com.ada.api.noaa.services.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    BoyaService service;

    @PostMapping("/boyas")
    public ResponseEntity<?> crearBoya(@RequestBody InfoBoyaNueva infoBoya){
        

        GenericResponse respuesta = new GenericResponse();

        Boya boya = service.crearBoya(infoBoya.latitudInstalacion, infoBoya.longitudInstalacion);
        respuesta.isOk = true;
        respuesta.id = boya.getBoyaId();
        respuesta.message = "La boya fue creado con exito";

        return ResponseEntity.ok(respuesta);
    }


    @GetMapping("/boyas)")
    public ResponseEntity<List<Boya>> getBoyasSinMuestras(){
        return ResponseEntity.ok(service.traerTodas());
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
    public ResponseEntity<GenericResponse> actualizarBoyaId(@PathVariable Integer id, @RequestBody ColorNuevoLuz colorNuevo){
        Boya boya = service.buscarPorId(id);
        boya.setColorLuz(colorNuevo.colorLuz);
        service.guardar(boya);

     GenericResponse respuesta = new GenericResponse();
     respuesta.isOk = true;
     respuesta.message = "Color actualizado";
     return ResponseEntity.ok(respuesta);
 
    }
    

}
