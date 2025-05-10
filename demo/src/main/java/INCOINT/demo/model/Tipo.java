package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tipo")
public class Tipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipo_id")
    private int tipoId;

    @Column(name="tipo", length = 30, nullable = false)
    private String tipo;

    public Tipo() {}

    public Tipo(int tipoId, String tipo) {
        this.tipoId = tipoId;
        this.tipo = tipo;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
