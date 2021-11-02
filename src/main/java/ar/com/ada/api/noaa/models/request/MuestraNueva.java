package ar.com.ada.api.noaa.models.request;

import java.sql.Date;

import ar.com.ada.api.noaa.entities.Boya;

public class MuestraNueva {

    public Boya boya;
    public Date horarioMuestra;
    public String matriculaEmbarcacion;
    public double longitud;
    public double latitud;
    public double alturaNivelMar;

    
}
