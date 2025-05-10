package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity(name="trayecto")
public class Trayecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trayecto_id")
    private int trayectoId;

    @Column(name="trayecto_nombre", length = 60, nullable = false)
    private String trayectoNombre;

    @ManyToOne
    @JoinColumn(name="municipio_origen", nullable = false)
    private Municipio municipioOrigen;

    @ManyToOne
    @JoinColumn(name="municipio_destino")
    private Municipio municipioDestino;

    public Trayecto() {}

    public Trayecto(int trayectoId, String trayectoNombre, Municipio municipioOrigen, Municipio municipioDestino) {
        this.trayectoId = trayectoId;
        this.trayectoNombre = trayectoNombre;
        this.municipioOrigen = municipioOrigen;
        this.municipioDestino = municipioDestino;
    }

    public int getTrayectoId() {
        return trayectoId;
    }

    public void setTrayectoId(int trayectoId) {
        this.trayectoId = trayectoId;
    }

    public String getTrayectoNombre() {
        return trayectoNombre;
    }

    public void setTrayectoNombre(String trayectoNombre) {
        this.trayectoNombre = trayectoNombre;
    }

    public Municipio getMunicipioOrigen() {
        return municipioOrigen;
    }

    public void setMunicipioOrigen(Municipio municipioOrigen) {
        this.municipioOrigen = municipioOrigen;
    }

    public Municipio getMunicipioDestino() {
        return municipioDestino;
    }

    public void setMunicipioDestino(Municipio municipioDestino) {
        this.municipioDestino = municipioDestino;
    }
}
