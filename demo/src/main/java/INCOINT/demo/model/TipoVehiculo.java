package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tipo_vehiculo")
public class TipoVehiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipo_vehiculo_id")
    private int tipoVehiculoId;

    @Column(name="tipo_vehiculo", length = 40, nullable = false)
    private String tipoVehiculo;

    public TipoVehiculo() {}

    public TipoVehiculo(int tipoVehiculoId, String tipoVehiculo) {
        this.tipoVehiculoId = tipoVehiculoId;
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(int tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}
