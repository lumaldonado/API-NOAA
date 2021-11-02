package ar.com.ada.api.noaa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Boya.ColorLuzEnum;
import ar.com.ada.api.noaa.repos.BoyaRepository;

@Service
public class BoyaService {

    @Autowired
    BoyaRepository repo;

    public Boya crearBoya(double longitudInstalacion, double latitudInstalacion) {
        Boya boya = new Boya();
        boya.setColorLuz(ColorLuzEnum.VERDE);
        boya.setLatitudInstalacion(latitudInstalacion);
        boya.setLongitudInstalacion(longitudInstalacion);
        return repo.save(boya);
    }

    public List<Boya> traerTodas() {
        return repo.findAll();
    }

    public Boya buscarPorId(Integer id) {

        return repo.findByBoyaId(id);
    }

    public void guardar(Boya boya) {
        repo.save(boya);
    }

}
