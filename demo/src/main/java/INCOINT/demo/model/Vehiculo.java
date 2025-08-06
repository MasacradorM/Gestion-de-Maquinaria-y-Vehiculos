package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity(name="vehiculos")
public class Vehiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehiculo_id")
    private int vehiculoId;

    @ManyToOne
    @JoinColumn(name="tipo_vehiculo_id", nullable = false)
    private TipoVehiculo tipoVehiculo;

    @Column(name="vehiculo", length = 30, nullable = false)
    private String vehiculo;

    @Column(name="fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name="estatus", nullable = false)
    private boolean estatus;

    public Vehiculo() {}

    public Vehiculo(int vehiculoId, TipoVehiculo tipoVehiculo, String vehiculo, LocalDateTime fechaRegistro, boolean estatus) {
        this.vehiculoId = vehiculoId;
        this.tipoVehiculo = tipoVehiculo;
        this.vehiculo = vehiculo;
        this.fechaRegistro = fechaRegistro;
        this.estatus = estatus;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
}
