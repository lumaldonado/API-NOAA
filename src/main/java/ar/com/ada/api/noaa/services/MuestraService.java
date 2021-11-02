package ar.com.ada.api.noaa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.entities.Boya.ColorLuzEnum;
import ar.com.ada.api.noaa.repos.MuestraRepository;

@Service
public class MuestraService {

    @Autowired
    MuestraRepository repo;

    @Autowired
    BoyaService service;

    public List<Muestra> traerMuestras() {
        return repo.findAll();
    }

    public void crearMuestra(Muestra muestras) {
        repo.save(muestras);
    }

    public Muestra buscarMuestra(Integer id) {
        Optional<Muestra> resultado = repo.findById(id);

        if (resultado.isPresent())
            return resultado.get();

        return null;

    }

    public void bajaMuestraPorId(Integer id) {
        Muestra muestra = repo.findByMuestraId(id);
        Boya boya = muestra.getBoya();
        boya.setColorLuz(ColorLuzEnum.AZUL);
        service.guardar(boya);
        repo.save(muestra);
    }

    

}
