package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity(name="maquinas")
public class Maquina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="maquina_id")
    private int maquinaId;

    @ManyToOne
    @JoinColumn(name="tipo_maquinaria_id", nullable = false)
    private TipoMaquinaria tipoMaquinaria;

    @Column(name="maquina", length = 30, nullable = false)
    private String maquina;

    @Column(name="fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name="estatus", nullable = false)
    private boolean estatus;

    public Maquina() {}

    public Maquina(int maquinaId, TipoMaquinaria tipoMaquinaria, String maquina, LocalDateTime fechaRegistro, boolean estatus) {
        this.maquinaId = maquinaId;
        this.tipoMaquinaria = tipoMaquinaria;
        this.maquina = maquina;
        this.fechaRegistro = fechaRegistro;
        this.estatus = estatus;
    }

    public int getMaquinaId() {
        return maquinaId;
    }

    public void setMaquinaId(int maquinaId) {
        this.maquinaId = maquinaId;
    }

    public TipoMaquinaria getTipoMaquinaria() {
        return tipoMaquinaria;
    }

    public void setTipoMaquinaria(TipoMaquinaria tipoMaquinaria) {
        this.tipoMaquinaria = tipoMaquinaria;
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
