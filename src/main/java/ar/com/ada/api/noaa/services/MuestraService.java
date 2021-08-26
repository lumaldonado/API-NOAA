package ar.com.ada.api.noaa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.repos.MuestraRepository;

@Service
public class MuestraService {

    @Autowired
    private MuestraRepository repo;

    public void crearMuestra(Muestra muestras) {
        repo.save(muestras);
    }

    public Muestra buscarMuestra(Integer id){
        Optional<Muestra> resultado = repo.findById(id);
        
        if(resultado.isPresent())
            return resultado.get();
        
        return null;    

   }

    public void eliminarMuestraPorId(Integer id) {
        Muestra muestra = this.buscarMuestra(id); 
       repo.save(muestra);
    }
    
}
