package ar.com.ada.api.noaa.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "boya")
public class Boya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boya_id")
    private Integer id;

    @Column(name = "color_luz_id")
    private Integer colorLuz;

    @Column(name = "longitud_instalacion")
    private Double longitudInstalacion;

    @Column(name = "latitud_instalacion")
    private Double latitudInstalacion;

    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Muestra> muestras = new ArrayList<>();

    public void agregarMuestra(Muestra muestra){
        this.muestras.add(muestra);
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ColorLuzEnum getColorLuz() {
        return ColorLuzEnum.parse(colorLuz);
    }

    public void setColorLuz(ColorLuzEnum colorLuz) {
        this.colorLuz = colorLuz.getValue();
    }

    public Double getLongitudInstalacion() {
        return longitudInstalacion;
    }

    public void setLongitudInstalacion(Double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }

    public Double getLatitudInstalacion() {
        return latitudInstalacion;
    }

    public void setLatitudInstalacion(Double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }


    public enum ColorLuzEnum {

        ROJO(1), AMARILLO(2), VERDE(3), AZUL(4);

        private final Integer value;

        private ColorLuzEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static ColorLuzEnum parse(Integer id) {
            ColorLuzEnum status = null; // Default
            for (ColorLuzEnum item : ColorLuzEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }
}


    

