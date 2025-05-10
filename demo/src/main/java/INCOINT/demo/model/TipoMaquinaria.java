package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tipo_maquinaria")
public class TipoMaquinaria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipo_maquinaria_id")
    private int tipoMaquinariaId;

    @Column(name="tipo_maquinaria", length = 40, nullable = false)
    private String tipoMaquinaria;

    public TipoMaquinaria() {}

    public TipoMaquinaria(int tipoMaquinariaId, String tipoMaquinaria) {
        this.tipoMaquinariaId = tipoMaquinariaId;
        this.tipoMaquinaria = tipoMaquinaria;
    }

    public int getTipoMaquinariaId() {
        return tipoMaquinariaId;
    }

    public void setTipoMaquinariaId(int tipoMaquinariaId) {
        this.tipoMaquinariaId = tipoMaquinariaId;
    }

    public String getTipoMaquinaria() {
        return tipoMaquinaria;
    }

    public void setTipoMaquinaria(String tipoMaquinaria) {
        this.tipoMaquinaria = tipoMaquinaria;
    }
}
