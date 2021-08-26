package ar.com.ada.api.noaa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.models.request.BoyaSinMuestras;
import ar.com.ada.api.noaa.repos.BoyaRepository;

@Service
public class BoyaService {

    @Autowired
    private BoyaRepository repo;

    public void crearBoya(Boya boya) {

        repo.save(boya);
    }

    public List<Boya> traerBoyasSinMuestras() {
        return repo.findBoyas();
    }

    public Boya buscarPorId(Integer id) {

    Optional<Boya> resultado = repo.findById(id);
            
            if(resultado.isPresent())
                return resultado.get();
            
            return null;    
   
       }

       public void guardar(Boya boya) {
        repo.save(boya);
    }
    
}
