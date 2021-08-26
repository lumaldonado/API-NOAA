package ar.com.ada.api.noaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.models.request.MuestraNueva;
import ar.com.ada.api.noaa.models.response.GenericResponse;
import ar.com.ada.api.noaa.services.MuestraService;

@RestController
public class MuestraController {

    @Autowired
    MuestraService service;

    @PostMapping("/muestras")
    public ResponseEntity<?> crearMuestra(@RequestBody MuestraNueva muestraNueva){
        GenericResponse respuesta = new GenericResponse();

        Muestra muestras = new Muestra();
        muestras.setAlturaNivelMar(muestraNueva.alturaNivelMar);
        muestras.setBoya(muestraNueva.boya);
        muestras.setHorarioMuestra(muestraNueva.horarioMuestra);
        muestras.setLatitud(muestraNueva.latitud);
        muestras.setLongitud(muestraNueva.longitud);
        muestras.setMatriculaEmbarcacion(muestraNueva.matriculaEmbarcacion);

        service.crearEmpleada(muestras);
        respuesta.isOk = true;
        respuesta.id = muestras.getId();
        respuesta.message = "La Muestra fue creada con exito";

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/muestras/boyas/{idBoya}")

    @GetMapping("/muestras/colores/{color}")

    @GetMapping("muestras/minima/{idBoya}")

    @DeleteMapping("/muestras/{id}")
    ublic ResponseEntity<GenericResponse> eliminarMuestra(@PathVariable Integer id){
        service.eliminarEmpleadaPorId(id);
        GenericResponse respuesta = new GenericResponse();
        respuesta.isOk = true;
        respuesta.id = id;
        respuesta.message = "La empleada fue dada de baja con exito";
        return ResponseEntity.ok(respuesta);
    
       }
    
}
