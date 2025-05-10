package INCOINT.demo.DTO;

import java.time.LocalDateTime;

public class VehiculoDTO {

    private int tipoVehiculoId;
    private String vehiculo;
    private LocalDateTime fechaRegistro;
    private boolean estatus;

    public VehiculoDTO(int tipoVehiculoId, String vehiculo, LocalDateTime fechaRegistro, boolean estatus) {
        this.tipoVehiculoId = tipoVehiculoId;
        this.vehiculo = vehiculo;
        this.fechaRegistro = fechaRegistro;
        this.estatus = estatus;
    }

    public int getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(int tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
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
