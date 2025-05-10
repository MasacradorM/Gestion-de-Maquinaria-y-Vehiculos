package INCOINT.demo.DTO;

import java.time.LocalDateTime;

public class MaquinaDTO {

    private int tipoMaquinariaId;
    private String maquina;
    private LocalDateTime fechaRegistro;
    private boolean estatus;

    public MaquinaDTO(int tipoMaquinariaId, String maquina, LocalDateTime fechaRegistro, boolean estatus) {
        this.tipoMaquinariaId = tipoMaquinariaId;
        this.maquina = maquina;
        this.fechaRegistro = fechaRegistro;
        this.estatus = estatus;
    }

    public int getTipoMaquinariaId() {
        return tipoMaquinariaId;
    }

    public void setTipoMaquinariaId(int tipoMaquinariaId) {
        this.tipoMaquinariaId = tipoMaquinariaId;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
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
